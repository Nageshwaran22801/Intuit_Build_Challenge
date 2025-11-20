package com.example.demo.producer;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * The producer taking numbers from the source list and simply calls queue.put(value).
 * If the queue is full:
 *   - put() will automatically block (wait) until the consumer removes something.
 */
public class BlockingProducer implements Runnable{

    private final List<Integer> sources;
    private final BlockingQueue<Integer> blockingQueue;

    public BlockingProducer(List<Integer> sources, BlockingQueue<Integer> blockingQueue) {
        this.sources = sources;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int value : sources) {
            try {
                // put() will block if queue is full, it automatically synchronized
                blockingQueue.put(value);
                System.out.println("[Blocking Producer] Produced: " + value);
                // Slow down producer slightly for readable output
                Thread.sleep(300);
            } catch (Exception ignored) {}
        }
    }

}
