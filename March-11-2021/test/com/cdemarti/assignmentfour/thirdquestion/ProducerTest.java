package com.cdemarti.assignmentfour.thirdquestion;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProducerTest {

    @Test
    public void testBufferSize() {
        Producer testProducer = new Producer();
        assertEquals(4, testProducer.buffer.capacity());
    }

    @Test
    public void testBufferFill() {
        Producer testProducer = new Producer();
        testProducer.run();
        assertEquals(4, testProducer.buffer.length());
    }


}