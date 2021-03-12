package com.cdemarti.assignmentfour.thirdquestion;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConsumerTest {

    @Test
    public void checkBufferSizeBefore(){
        Producer p = new Producer();
        Consumer testConsumer = new Consumer(p);
        p.run();
        assertEquals(4, testConsumer.p.buffer.length());
    }

}