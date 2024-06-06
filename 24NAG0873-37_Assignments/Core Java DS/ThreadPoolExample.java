package DAY23Assignments;
import java.util.concurrent.*;

public class ThreadPoolExample {

    public static void main(String[] args) {
        // Create a fixed thread pool with 4 threads
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Submit multiple tasks to the thread pool
        Future<Integer> future1 = executorService.submit(new ComplexCalculationTask(10));
        Future<Integer> future2 = executorService.submit(new ComplexCalculationTask(20));
        Future<Integer> future3 = executorService.submit(new ComplexCalculationTask(30));
        Future<Integer> future4 = executorService.submit(new ComplexCalculationTask(40));
        Future<Integer> future5 = executorService.submit(new ComplexCalculationTask(50));

        try {
            // Get the results of the calculations
            System.out.println("Result of Task 1: " + future1.get());
            System.out.println("Result of Task 2: " + future2.get());
            System.out.println("Result of Task 3: " + future3.get());
            System.out.println("Result of Task 4: " + future4.get());
            System.out.println("Result of Task 5: " + future5.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor service
            executorService.shutdown();
        }
    }

    // A task that performs a complex calculation
    static class ComplexCalculationTask implements Callable<Integer> {
        private final int number;

        public ComplexCalculationTask(int number) {
            this.number = number;
        }

        @Override
        public Integer call() throws Exception {
            // Simulate a complex calculation
            int result = 0;
            for (int i = 1; i <= number; i++) {
                result += i;
                // Simulating time-consuming task
                Thread.sleep(100);
            }
            System.out.println("Completed calculation for: " + number);
            return result;
        }
    }
}