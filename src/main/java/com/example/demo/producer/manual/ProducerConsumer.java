package com.example.demo.producer.manual;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**  This class acts like the "manager" of the whole producer–consumer system.
*  It prepares:
*     - A source list (producer will read from it)
*     - A shared queue (producer and consumer communicate through this)
*     - A destination list (consumer will store final results here)
   And finally, it starts both threads.
 */
public class ProducerConsumer {

    private final List<Integer> sources = new ArrayList<>();

    //  Producer adds items here and consumer removes from here.
    private final LinkedList<Integer> sharedQueue = new LinkedList<>();

    //  Consumer will store consumed items here.
    private final List<Integer> destinations = new ArrayList<>();

    //  Max queue capacity, when queue is full, producer must wait.
    private final int QUEUE_SIZE = 5;

    // Create dummy data in sources list.
    public ProducerConsumer() {
        for (int i = 1; i <= 20; i++) {
            sources.add(i);
        }
    }

    public void startProcessing() {

        //Creating a producer thread and passing the source,queue and max size of queue.
        Thread producer = new Thread(new Producer(sources, sharedQueue, QUEUE_SIZE));

        //Creating a consumer thread and passing the shared queue and destination.
        Thread consumer = new Thread(new Consumer(sharedQueue, destinations));

        //Starting both of thread to run in parallel.
        producer.start();
        consumer.start();
    }

    // This is used in test cases to verify that consumer is storing items.
    public List<Integer> getDestinationList() {
        return destinations;
    }

}
