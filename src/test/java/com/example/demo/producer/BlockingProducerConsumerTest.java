package com.example.demo.producer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlockingProducerConsumerTest {

    @Test
    public void testBlockingProducerConsumerFlow() throws Exception {

        BlockingProducerConsumer bpc = new BlockingProducerConsumer();
        bpc.startProcessing();

        // Allow time for processing
        Thread.sleep(5000);

        assertTrue(bpc.getDestinationList().size() > 0);
    }

}
