package DAY23Assignments;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class PrimeNumberCalculator {

   public static void main(String[] args) {
       // Define the upper limit for prime number calculation
       int upperLimit = 1000;

       // Create an ExecutorService with a fixed thread pool
       ExecutorService executorService = Executors.newFixedThreadPool(4);

       // Use Concurrent Collections to store results
       ConcurrentMap<Integer, List<Integer>> primeResults = new ConcurrentHashMap<>();

       // Submit tasks to calculate primes in parallel
       for (int i = 0; i < 4; i++) {
           final int start = i * (upperLimit / 4);
           final int end = (i + 1) * (upperLimit / 4);
           executorService.submit(() -> {
               List<Integer> primes = calculatePrimesInRange(start, end);
               primeResults.put(start, primes);
           });
       }

       // Shutdown the executor service
       executorService.shutdown();
       try {
           // Wait for all tasks to complete
           executorService.awaitTermination(1, TimeUnit.HOURS);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       // Merge all prime numbers into a single list
       List<Integer> allPrimes = primeResults.values()
           .stream()
           .flatMap(List::stream)
           .sorted()
           .collect(Collectors.toList());

       // Use CompletableFuture to write results to a file asynchronously
       CompletableFuture<Void> fileWriteFuture = CompletableFuture.runAsync(() -> {
           try {
               writePrimesToFile(allPrimes, "primes.txt");
           } catch (IOException e) {
               e.printStackTrace();
           }
       });

       // Wait for the file writing to complete
       fileWriteFuture.join();
       System.out.println("Prime numbers written to primes.txt");
   }

   private static List<Integer> calculatePrimesInRange(int start, int end) {
       List<Integer> primes = new ArrayList<>();
       for (int num = Math.max(start, 2); num < end; num++) {
           if (isPrime(num)) {
               primes.add(num);
           }
       }
       return primes;
   }

   private static boolean isPrime(int num) {
       if (num <= 1) return false;
       for (int i = 2; i <= Math.sqrt(num); i++) {
           if (num % i == 0) return false;
       }
       return true;
   }

   private static void writePrimesToFile(List<Integer> primes, String filename) throws IOException {
       Path filePath = Paths.get(filename);
       Files.write(filePath, primes.stream().map(String::valueOf).collect(Collectors.toList()));
   }
}
