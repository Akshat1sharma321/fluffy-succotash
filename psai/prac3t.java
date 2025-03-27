package psai;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class prac3t {
    static class NumberPrinterTask implements Runnable {
        private String taskName;
        private int maxCount;

        // Constructor to initialize task with name and count
        public NumberPrinterTask(String name, int count) {
            this.taskName = name;
            this.maxCount = count;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= maxCount; i++) {
                    System.out.println(taskName + ": Count = " + i);
                    
                    // Simulate some processing time
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println(taskName + " task interrupted.");
            }
        }
    }

    // Another Runnable implementation for printing alphabets
    static class AlphabetPrinterTask implements Runnable {
        @Override
        public void run() {
            try {
                for (char c = 'A'; c <= 'Z'; c++) {
                    System.out.println("Alphabet Task: " + c);
                    
                    // Simulate some processing time
                    Thread.sleep(700);
                }
            } catch (InterruptedException e) {
                System.out.println("Alphabet task interrupted.");
            }
        }
    }

    // Runnable task demonstrating priority and state
    static class PriorityDemoTask implements Runnable {
        private String name;

        public PriorityDemoTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " is running with priority: " + 
                    Thread.currentThread().getPriority());
                
                // Simulate task duration
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(name + " task interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        // Method 1: Creating and starting threads manually
        System.out.println("--- Manual Thread Creation ---");
        NumberPrinterTask numberTask1 = new NumberPrinterTask("Number Task 1", 5);
        NumberPrinterTask numberTask2 = new NumberPrinterTask("Number Task 2", 5);
        
        Thread thread1 = new Thread(numberTask1);
        Thread thread2 = new Thread(numberTask2);
        Thread alphabetThread = new Thread(new AlphabetPrinterTask());

        // Demonstrate thread priority
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        alphabetThread.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        alphabetThread.start();

        // Method 2: Using ExecutorService for thread management
        System.out.println("\n--- Executor Service Demonstration ---");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to executor service
        executor.submit(new PriorityDemoTask("Executor Task 1"));
        executor.submit(new PriorityDemoTask("Executor Task 2"));
        executor.submit(new PriorityDemoTask("Executor Task 3"));

        // Shutdown the executor service
        executor.shutdown();

        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
            alphabetThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("All tasks have completed execution.");
    }
}
