package DAY23Assignments;

import java.util.LinkedList;

public class ProducerConsumerExample {
    private static final int CAPACITY = 5;
    private final LinkedList<Integer> list = new LinkedList<>();
    private final Object lock = new Object();

    // Producer thread will produce items
    class Producer implements Runnable {
        @Override
        public void run() {
            int value = 0;
            while (true) {
                synchronized (lock) {
                    try {
                        // Wait while the list is full
                        while (list.size() == CAPACITY) {
                            lock.wait();
                        }

                        System.out.println("Producer produced-" + value);

                        // to insert the jobs in the list
                        list.add(value++);

                        // notifies the consumer thread that now it can start consuming
                        lock.notify();

                        // makes the working of program easier to understand
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // Consumer thread will consume items
    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    try {
                        // Wait while the list is empty
                        while (list.size() == 0) {
                            lock.wait();
                        }

                        // to retrieve the first job in the list
                        int val = list.removeFirst();

                        System.out.println("Consumer consumed-" + val);

                        // Wake up producer thread
                        lock.notify();

                        // and sleep
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void start() {
        Thread prodThread = new Thread(new Producer());
        Thread consThread = new Thread(new Consumer());

        prodThread.start();
        consThread.start();
    }

    public static void main(String[] args) {
        ProducerConsumerExample example = new ProducerConsumerExample();
        example.start();
        
    }
}