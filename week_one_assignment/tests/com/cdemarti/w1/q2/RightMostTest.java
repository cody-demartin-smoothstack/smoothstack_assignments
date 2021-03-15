package com.cdemarti.w1.q2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RightMostTest {

    @Test
    public void testNewArrayMethodOneThroughNine() {
        List<Integer> testOne = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        RightMost test = new RightMost(testOne);

        assertEquals(testOne, test.createNewArray(test.list));
    }

    @Test
    public void testNewArrayMethodBigNumbers(){
        List<Integer> testTwo = Arrays.asList(12342342, 1234123412, 532559);
        RightMost test = new RightMost(testTwo);

        List<Integer> results = Arrays.asList(2, 2, 9);
        assertEquals(results, test.createNewArray(test.list));
    }

    @Test
    public void testNewArrayMethodZero(){
        List<Integer> testThree = Arrays.asList(0);
        RightMost test = new RightMost(testThree);

        List<Integer> results = Arrays.asList(0);
        assertEquals(results, test.createNewArray(test.list));
    }
}