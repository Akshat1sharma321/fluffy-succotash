package psai;

public class prac5f {
    static class SharedCounter {
        private int count = 0;

        // Synchronized method to increment counter
        public synchronized void increment() {
            int currentCount = count;
            
            // Simulate some processing time to expose potential race conditions
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            count = currentCount + 1;
            System.out.println(Thread.currentThread().getName() + 
                               " incremented count to: " + count);
        }

        // Getter method to retrieve current count
        public synchronized int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        // Create a shared counter
        SharedCounter counter = new SharedCounter();

        // Create multiple threads to increment the counter
        Runnable incrementTask = () -> {
            for (int i = 0; i < 3; i++) {
                counter.increment();
            }
        };

        // Create and start multiple threads
        Thread thread1 = new Thread(incrementTask, "Thread-1");
        Thread thread2 = new Thread(incrementTask, "Thread-2");
        Thread thread3 = new Thread(incrementTask, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final count
        System.out.println("Final Count: " + counter.getCount());
    }
}
