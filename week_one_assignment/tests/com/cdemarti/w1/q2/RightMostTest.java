package com.cdemarti.w1.q2;

import org.junit.Test;

import static org.junit.Assert.*;

public class RightMostTest {

    @Test
    public void testNewArrayMethodOneThroughNine() {
        Integer[] testOne = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        RightMost test = new RightMost(testOne);

        assertArrayEquals(testOne, test.createNewArray(test.list));
    }

    @Test
    public void testNewArrayMethodBigNumbers(){
        Integer[] testTwo = {12342342, 1234123412, 532559};
        RightMost test = new RightMost(testTwo);

        Integer[] results = {2, 2, 9};
        assertArrayEquals(results, test.createNewArray(test.list));
    }

    @Test
    public void testNewArrayMethodZero(){
        Integer[] testTwo = {0};
        RightMost test = new RightMost(testTwo);

        Integer[] results = {0};
        assertArrayEquals(results, test.createNewArray(test.list));
    }
}