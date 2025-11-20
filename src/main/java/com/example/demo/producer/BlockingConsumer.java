package com.example.demo.producer;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * The consumer repeatedly calls queue.take().
 * If the queue is empty, take() will automatically block (wait) until producer adds something.
 * After consuming each item, it stores the value into the destination list.
 */
public class BlockingConsumer implements Runnable{

    private final BlockingQueue<Integer> queue;
    private final List<Integer> destinations;

    public BlockingConsumer(BlockingQueue<Integer> queue, List<Integer> destinationList) {
        this.queue = queue;
        this.destinations = destinationList;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // take() blocks until queue has an item for performing perfect synchronization.
                int item = queue.take();
                // Add the consumed item into destination list
                destinations.add(item);
                System.out.println("[Blocking Consumer] Consumed: " + item);
                // Slow down consumer slightly
                Thread.sleep(500);
            }
        } catch (Exception ignored) {}
    }

}
