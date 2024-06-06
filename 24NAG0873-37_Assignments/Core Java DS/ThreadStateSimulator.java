package DAY23Assignments;
public class ThreadStateSimulator {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        // Thread in NEW state
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    // Thread in RUNNABLE state
                    // Simulate some work
                    Thread.sleep(1000);

                    // Thread in TIMED_WAITING state
                    lock.wait(2000);

                    // Thread in WAITING state
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Start the thread, making it RUNNABLE
        thread.start();

        // Main thread sleeps, allowing the new thread to go ahead
        Thread.sleep(500);

        synchronized (lock) {
            // Main thread will block until the new thread goes to WAITING state
            while (thread.getState() != Thread.State.TIMED_WAITING) {
                Thread.sleep(100);
            }

            // Thread in BLOCKED state as it tries to enter the synchronized block
            lock.notify(); // Will move the new thread to BLOCKED state temporarily

            // Main thread sleeps, allowing the new thread to finish execution
            Thread.sleep(5000);
        }

        // Wait for the thread to TERMINATE
        thread.join();

        // Print the final state of the thread
        System.out.println("Thread state after termination: " + thread.getState());
    }
}
