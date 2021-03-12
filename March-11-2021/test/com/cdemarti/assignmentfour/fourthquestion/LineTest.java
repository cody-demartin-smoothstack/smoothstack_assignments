package com.cdemarti.assignmentfour.fourthquestion;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class LineTest {


    @Test
    public void testSlopeHP(){
        Line testLine = new Line(3, 3, 6, 6);
        assertEquals(1, testLine.getSlope(), .0001);
    }

//    @Test
//    public void testSlopeBP(){
//        Line testLine = new Line(3, 3, 3, 6);
//        Exception noZero = new ArithmeticException();
//        assertSame(noZero, testLine.getSlope());
//    }

    @Test
    public void testDistance(){
        Line testLine = new Line(0, 3, 2, 6);
        assertEquals(3.60555127546, testLine.getDistance(), .0001);
    }

    @Test
    public void testParallelHP(){
        Line testLine1 = new Line(0, 3, 2, 6);
        Line testLine2 = new Line(0, 3, 2, 6);
        assertEquals(true, testLine1.parallelTo(testLine2));
    }

    @Test
    public void testParallelUP(){
        Line testLine1 = new Line(0, 3, 2, 6);
        Line testLine2 = new Line(0, 3, 2, 100);
        assertEquals(false, testLine1.parallelTo(testLine2));
    }


}