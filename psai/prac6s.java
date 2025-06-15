// package psai;

public class prac6s {
    static class TicketBookingSystem {
        private static int availableSeats = 3; // Total available seats

        // Static synchronized method for booking seats
        public static synchronized boolean bookSeat(String passengerName) {
            if (availableSeats > 0) {
                try {
                    // Simulate processing time
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                // Reduce available seats
                availableSeats--;
                
                System.out.println(passengerName + " booked a seat. " + 
                                   "Seats remaining: " + availableSeats);
                return true;
            } else {
                System.out.println(passengerName + " couldn't book. No seats available!");
                return false;
            }
        }
    }

    public static void main(String[] args) {
        // Create multiple threads trying to book seats
        Runnable bookingTask = () -> {
            String passengerName = Thread.currentThread().getName();
            bookTicket(passengerName);
        };

        // Create and start multiple booking threads
        Thread passenger1 = new Thread(bookingTask, "Passenger 1");
        Thread passenger2 = new Thread(bookingTask, "Passenger 2");
        Thread passenger3 = new Thread(bookingTask, "Passenger 3");
        Thread passenger4 = new Thread(bookingTask, "Passenger 4");

        passenger1.start();
        passenger2.start();
        passenger3.start();
        passenger4.start();

        // Wait for all threads to complete
        try {
            passenger1.join();
            passenger2.join();
            passenger3.join();
            passenger4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to book ticket using static synchronized method
    private static void bookTicket(String passengerName) {
        TicketBookingSystem.bookSeat(passengerName);
    }
}
