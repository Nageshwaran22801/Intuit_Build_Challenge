package com.example.demo.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingProducerConsumer {

    private final List<Integer> sources = new ArrayList<>();
    private final List<Integer> destinations = new ArrayList<>();

    private final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

    public BlockingProducerConsumer() {
        for (int i = 1; i <= 20; i++) {
            sources.add(i);
        }
    }

    public void startProcessing() {

        new Thread(new BlockingProducer(sources, blockingQueue)).start();
        new Thread(new BlockingConsumer(blockingQueue, destinations)).start();
    }

    public List<Integer> getDestinationList() {
        return destinations;
    }
}
