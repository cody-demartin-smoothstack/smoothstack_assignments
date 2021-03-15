package com.cdemarti.w1.q4;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CharRemoveTest {

    @Test
    public void testSampleInput(){
        List<String> testCase = Arrays.asList("xxax", "xbxbx", "xxcx");
        CharRemove testOne = new CharRemove();
        List<String> expected = Arrays.asList("a", "bb", "c");

        assertTrue(expected.containsAll(testOne.pruneString(testCase, "x")));
    }

    @Test
    public void testDifferentLetter(){
        List<String> testCase = Arrays.asList("yax", "ybxby", "yycx");
        CharRemove testOne = new CharRemove();
        List<String> expected = Arrays.asList("ax", "bxb", "cx");

        assertTrue(expected.containsAll(testOne.pruneString(testCase, "y")));
    }

    @Test
    public void testEmptyInput(){
        List<String> testCase = Arrays.asList("");
        CharRemove testOne = new CharRemove();
        List<String> expected = Arrays.asList("");

        assertTrue(expected.containsAll(testOne.pruneString(testCase, "x")));
    }

    @Test
    public void testSingleLetter(){
        List<String> testCase = Arrays.asList("x");
        CharRemove testOne = new CharRemove();
        List<String> expected = Arrays.asList("");

        assertTrue(expected.containsAll(testOne.pruneString(testCase, "x")));
    }
}