package DAY23Assignments;

import java.util.concurrent.locks.ReentrantLock;

//Thread-safe Counter class
class Counter {
   private int count = 0;
   private final ReentrantLock lock = new ReentrantLock();

   public void increment() {
       lock.lock();
       try {
           count++;
       } finally {
           lock.unlock();
       }
   }

   public void decrement() {
       lock.lock();
       try {
           count--;
       } finally {
           lock.unlock();
       }
   }

   public int getCount() {
       lock.lock();
       try {
           return count;
       } finally {
           lock.unlock();
       }
   }
}

//Immutable Data class
final class Data {
   private final String message;
   private final int value;

   public Data(String message, int value) {
       this.message = message;
       this.value = value;
   }

   public String getMessage() {
       return message;
   }

   public int getValue() {
       return value;
   }
}

//Main class to demonstrate usage
public class ThreadSafeExample {

   public static void main(String[] args) {
       Counter counter = new Counter();

       // Creating multiple threads to increment and decrement the counter
       Runnable incrementTask = () -> {
           for (int i = 0; i < 1000; i++) {
               counter.increment();
           }
       };

       Runnable decrementTask = () -> {
           for (int i = 0; i < 1000; i++) {
               counter.decrement();
           }
       };

       Thread thread1 = new Thread(incrementTask);
       Thread thread2 = new Thread(decrementTask);
       Thread thread3 = new Thread(incrementTask);
       Thread thread4 = new Thread(decrementTask);

       // Start the threads
       thread1.start();
       thread2.start();
       thread3.start();
       thread4.start();

       // Wait for all threads to finish
       try {
           thread1.join();
           thread2.join();
           thread3.join();
           thread4.join();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       // Print the final counter value
       System.out.println("Final counter value: " + counter.getCount());

       // Using the immutable Data class
       Data data = new Data("Immutable data", 42);

       // Creating multiple threads to access the immutable Data object
       Runnable dataTask = () -> {
           System.out.println(Thread.currentThread().getName() + " - Message: " + data.getMessage() + ", Value: " + data.getValue());
       };

       Thread dataThread1 = new Thread(dataTask);
       Thread dataThread2 = new Thread(dataTask);

       // Start the threads
       dataThread1.start();
       dataThread2.start();

       // Wait for all threads to finish
       try {
           dataThread1.join();
           dataThread2.join();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}
