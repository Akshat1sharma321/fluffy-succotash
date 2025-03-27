package psai;

public class prac4f {
    static class BankAccount {
        private int balance = 1000;

        // Synchronized method for withdrawing money
        public void withdraw(int amount) {
            synchronized (this) {
                if (balance >= amount) {
                    try {
                        // Simulate processing time
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + 
                                       " withdrew " + amount + 
                                       ". Remaining balance: " + balance);
                } else {
                    System.out.println(Thread.currentThread().getName() + 
                                       " - Insufficient funds!");
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create a shared bank account
        BankAccount account = new BankAccount();

        // Create multiple threads attempting to withdraw
        Runnable withdrawTask = () -> {
            account.withdraw(500);
        };

        // Create and start multiple threads
        Thread thread1 = new Thread(withdrawTask, "Customer 1");
        Thread thread2 = new Thread(withdrawTask, "Customer 2");

        thread1.start();
        thread2.start();

        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
