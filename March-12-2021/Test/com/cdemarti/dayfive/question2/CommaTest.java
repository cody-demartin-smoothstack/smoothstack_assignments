package com.cdemarti.dayfive.question2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CommaTest {

    @Test
    public void testEvenOdd(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Comma test = new Comma();


        assertEquals("o1, e2, o3, e4, o5", test.addToInteger(numbers));
    }
}