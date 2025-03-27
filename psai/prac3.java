import java.util.*;

public class prac3 {
    // Method using 'throws' to declare potential exceptions
    static class NumberPrinterThread extends Thread {
        private String threadName;
        private int maxCount;

        // Constructor to initialize thread with name and count
        public NumberPrinterThread(String name, int count) {
            this.threadName = name;
            this.maxCount = count;
        }

        // Override the run method - defines the thread's execution
        @Override
        public void run() {
            try {
                for (int i = 1; i <= maxCount; i++) {
                    System.out.println(threadName + ": Count = " + i);
                    
                    // Simulate some processing time
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println(threadName + " thread interrupted.");
            }
        }
    }

    // Extending Thread class for another custom thread
    static class AlphabetPrinterThread extends Thread {
        @Override
        public void run() {
            try {
                for (char c = 'A'; c <= 'Z'; c++) {
                    System.out.println("Alphabet Thread: " + c);
                    
                    // Simulate some processing time
                    Thread.sleep(700);
                }
            } catch (InterruptedException e) {
                System.out.println("Alphabet thread interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        // Create thread instances
        NumberPrinterThread thread1 = new NumberPrinterThread("Number Thread 1", 10);
        NumberPrinterThread thread2 = new NumberPrinterThread("Number Thread 2", 8);
        AlphabetPrinterThread alphabetThread = new AlphabetPrinterThread();

        // Start the threads
        thread1.start();
        thread2.start();
        alphabetThread.start();

        // Demonstrating thread lifecycle
        try {
            // Wait for threads to complete
            thread1.join();
            thread2.join();
            alphabetThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("All threads have completed execution.");
    }
}
