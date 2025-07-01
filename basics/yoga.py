import tensorflow as tf
import tensorflow_hub as hub
import numpy as np
import cv2
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Dropout
import mediapipe as mp

class YogaPoseDetector:
    def __init__(self):
        # Initialize MediaPipe Pose
        self.mp_pose = mp.solutions.pose
        self.pose = self.mp_pose.Pose(
            static_image_mode=False,
            model_complexity=2,
            min_detection_confidence=0.5,
            min_tracking_confidence=0.5
        )
        self.mp_drawing = mp.solutions.drawing_utils
        
        # Initialize the pose classification model
        self.model = self._build_model()
        
    def _build_model(self):
        # Create a simple neural network for pose classification
        model = Sequential([
            Dense(128, activation='relu', input_shape=(33*3,)),  # 33 landmarks with x,y,z coordinates
            Dropout(0.2),
            Dense(64, activation='relu'),
            Dropout(0.2),
            Dense(32, activation='relu'),
            Dense(4, activation='softmax')  # Assuming 4 yoga poses to classify
        ])
        model.compile(optimizer='adam',
                     loss='categorical_crossentropy',
                     metrics=['accuracy'])
        return model
    
    def extract_pose_landmarks(self, image):
        """Extract pose landmarks from an image using MediaPipe."""
        image_rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
        results = self.pose.process(image_rgb)
        
        if not results.pose_landmarks:
            return None
            
        # Extract landmark coordinates
        landmarks = []
        for landmark in results.pose_landmarks.landmark:
            landmarks.extend([landmark.x, landmark.y, landmark.z])
            
        return np.array(landmarks)
    
    def analyze_pose(self, image):
        """Analyze the yoga pose in the given image."""
        landmarks = self.extract_pose_landmarks(image)
        if landmarks is None:
            return "No pose detected"
            
        # Reshape landmarks for model input
        landmarks = landmarks.reshape(1, -1)
        
        # Get pose prediction
        prediction = self.model.predict(landmarks)
        pose_index = np.argmax(prediction)
        
        # Map index to pose name (example mapping)
        pose_names = ["Warrior", "Tree", "Downward Dog", "Mountain"]
        detected_pose = pose_names[pose_index]
        confidence = prediction[0][pose_index]
        
        return self._check_pose_alignment(landmarks, detected_pose)
    
    def _check_pose_alignment(self, landmarks, pose_name):
        """Check if the pose alignment is correct."""
        landmarks = landmarks.reshape(-1, 3)
        feedback = []
        
        if pose_name == "Warrior":
            # Check front knee angle
            knee_angle = self._calculate_angle(landmarks[23], landmarks[25], landmarks[27])
            if knee_angle < 85 or knee_angle > 95:
                feedback.append("Front knee should be at 90 degrees")
                
            # Check back leg straightness
            back_knee_angle = self._calculate_angle(landmarks[24], landmarks[26], landmarks[28])
            if back_knee_angle < 160:
                feedback.append("Back leg should be straighter")
                
        elif pose_name == "Tree":
            # Check standing leg straightness
            standing_knee_angle = self._calculate_angle(landmarks[23], landmarks[25], landmarks[27])
            if standing_knee_angle < 170:
                feedback.append("Standing leg should be straight")
                
            # Check hip alignment
            hip_alignment = abs(landmarks[23][1] - landmarks[24][1])
            if hip_alignment > 0.1:
                feedback.append("Keep hips level")
        
        return {
            "pose": pose_name,
            "is_correct": len(feedback) == 0,
            "feedback": feedback if feedback else ["Good form!"]
        }
    
    def _calculate_angle(self, p1, p2, p3):
        """Calculate angle between three points."""
        v1 = p1 - p2
        v2 = p3 - p2
        
        cos_angle = np.dot(v1, v2) / (np.linalg.norm(v1) * np.linalg.norm(v2))
        angle = np.arccos(cos_angle)
        
        return np.degrees(angle)
    
    def process_video(self, video_path=0):
        """Process video stream and provide real-time feedback."""
        cap = cv2.VideoCapture(video_path)
        
        while cap.isOpened():
            success, image = cap.read()
            if not success:
                break
                
            # Analyze pose
            result = self.analyze_pose(image)
            
            # Draw pose landmarks
            image_rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
            results = self.pose.process(image_rgb)
            if results.pose_landmarks:
                self.mp_drawing.draw_landmarks(
                    image,
                    results.pose_landmarks,
                    self.mp_pose.POSE_CONNECTIONS
                )
            
            # Display feedback
            y_pos = 30
            for feedback in result["feedback"]:
                cv2.putText(image, feedback, (10, y_pos), 
                           cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 0), 2)
                y_pos += 30
            
            cv2.imshow('Yoga Pose Analysis', image)
            if cv2.waitKey(5) & 0xFF == 27:  # Press ESC to exit
                break
                
        cap.release()
        cv2.destroyAllWindows()

# Example usage
detector = YogaPoseDetector()
# Process webcam feed
detector.process_video()