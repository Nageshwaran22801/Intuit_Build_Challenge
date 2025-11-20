package com.example.demo.producer.manual;

import java.util.LinkedList;
import java.util.List;

/**
 * The consumer keeps watching the queue, If queue is empty, it waits.
 * Whenever there is something inside, it consumes it
 * and stores the value into the destination list.
 */
public class Consumer implements Runnable{
    //shared queue
    private final LinkedList<Integer> queue;

    //Final result set
    private final List<Integer> destinations;

    public Consumer(LinkedList<Integer> queue, List<Integer> destinations) {
        this.queue = queue;
        this.destinations = destinations;
    }

    @Override
    public void run() {
        //Consumer will run continuously
        while (true) {

            int item;
            synchronized (queue) {

                // If queue is empty, consumer will wait
                while (queue.isEmpty()) {
                    try {
                        // Wait until producer produces something
                        queue.wait();
                    } catch (InterruptedException ignored) {}
                }

                // Remove one item from queue (consume)
                item = queue.removeFirst();

                // Storing the consumed item in the destination list
                destinations.add(item);
                System.out.println("[Manual Consumer] Consumed: " + item);

                // Informing producer that space is now available
                queue.notify(); // wake producer
            }

            try {
                Thread.sleep(500);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
