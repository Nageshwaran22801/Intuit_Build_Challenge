package com.example.demo.producer.manual;


import java.util.LinkedList;
import java.util.List;


/**
 * The producer reads numbers from the source list one by one.
 * If the queue is full, it politely waits.
 * When there is space, it adds the next number to the queue.
 */
public class Producer implements Runnable{
    //The data producer will read.
    private final List<Integer> sourceList;

    //Shared queue
    private final LinkedList<Integer> queue;

    //Max capacity of queue.
    private final int capacity;

    public Producer(List<Integer> sourceList, LinkedList<Integer> queue, int capacity) {
        this.sourceList = sourceList;
        this.queue = queue;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        // Producer goes through each number in the source list
        for (int value : sourceList) {

            synchronized (queue) {

                // If queue is full, producer must pause for consumer
                while (queue.size() == capacity) {
                    try {
                        // Waiting till consumer frees space
                        queue.wait();
                    } catch (InterruptedException ignored) {}
                }

                // Adding new item to the shared queue
                queue.add(value);
                System.out.println("[Manual Producer] Produced: " + value);

                // Informing consumer that a new item is available
                queue.notify(); // wake consumer
            }

            try {
                // sleep so the output looks readable
                Thread.sleep(300);
            } catch (Exception ignored) {}
        }
    }
}
