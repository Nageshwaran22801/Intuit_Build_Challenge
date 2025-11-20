package com.example.demo.producer;
import com.example.demo.producer.manual.ProducerConsumer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ProducerConsumerTest {

    @Test
    public void testManualProducerConsumerFlow() throws Exception {

        ProducerConsumer mpc = new ProducerConsumer();
        mpc.startProcessing();

        Thread.sleep(5000);

        // Ensure destination list is getting filled
        assertTrue(mpc.getDestinationList().size() > 0);
    }

}
