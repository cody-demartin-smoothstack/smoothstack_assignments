package com.cdemarti.dayfive.question1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LambdaTest {

    @Test
    public void testAscendingSort(){
        List<String> data = Arrays.asList("hellllloooo", "hello", "hi", "World:)", "end");
        Lambda testOne = new Lambda();
        List<String> expected = Arrays.asList("hi", "end","hello", "World:)", "hellllloooo");

        assertEquals(expected, testOne.lengthAscending(data));
    }

    @Test
    public void testDescendingSort(){
        List<String> data = Arrays.asList("hellllloooo", "hello", "hi", "World:)", "end");
        Lambda testOne = new Lambda();
        List<String> expected = Arrays.asList("hellllloooo", "World:)", "hello", "end", "hi");

        assertEquals(expected, testOne.lengthDescending(data));
    }

}