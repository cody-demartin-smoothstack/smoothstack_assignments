package com.cdemarti.w1.q3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DoubleIntegerTest {
    @Test
    public void testDoubleIterator(){
        DoubleInteger testOne = new DoubleInteger();

        List<Integer> testCase = Arrays.asList(2, 45, 90);
        List<Integer> expected = Arrays.asList(4, 90, 180);
        List<Integer> result = testOne.doubling(testCase);

        assertEquals(expected.size(), result.size());
        assertTrue(expected.containsAll(result));
    }

    @Test
    public void testDoubleStream(){
        DoubleInteger testOne = new DoubleInteger();

        List<Integer> testCase = Arrays.asList(2, 45, 90);
        List<Integer> expected = Arrays.asList(4, 90, 180);
        List<Integer> result = testOne.dub(testCase);

        assertEquals(expected.size(), result.size());
        assertTrue(expected.containsAll(result));
    }

    @Test
    public void testDoubleUnhappy(){
        DoubleInteger testOne = new DoubleInteger();

        List<Integer> testCase = Arrays.asList(2, 45, 90);
        List<Integer> expected = Arrays.asList(4, 90, 180, 100);
        List<Integer> result = testOne.doubling(testCase);

        assertFalse(expected.size() == result.size());
    }

}