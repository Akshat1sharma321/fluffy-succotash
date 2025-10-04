class Queue {
    int n = 10;
    int front = 0;
    int size = 0;
    int[] data = new int[n];

    public void push(int num) {
        if (size == n) {
            System.out.println("Space full");
            return;
        }
        int idx = (front + size) % n;
        data[idx] = num;
        size++;
    }

    public int poll() {
        if (size == 0) {
            System.out.println("No elem");
            return -1;
        }
        int val = data[front];
        front = (front + 1) % n;
        return val;
    }

    public int fron() {
        if (size == 0) {
            System.out.println("Queue empty");
            return -1;
        }
        return data[front];
    }
};

public class Question10_QueueImplementation {
    public static void main(String[] args) {
        Queue que = new Queue();
        que.push(7);
       System.out.println( que.fron() ); 
    }

}