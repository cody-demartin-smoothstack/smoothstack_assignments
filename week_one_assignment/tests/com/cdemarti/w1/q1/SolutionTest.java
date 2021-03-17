package com.cdemarti.w1.q1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void testIsOddHP(){
        Solution testAnswer = new Solution();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);


        Solution.checkOperation(testAnswer.isOdd(), 5);
        assertEquals("ODD\n", outputStream.toString());
    }

    @Test
    public void testIsOddUP(){
        Solution testAnswer = new Solution();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);


        Solution.checkOperation(testAnswer.isOdd(), 6);
        assertEquals("EVEN\n", outputStream.toString());
    }

    @Test
    public void testIsPrimeHP(){
        Solution testAnswer = new Solution();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);


        Solution.checkOperation(testAnswer.isPrime(), 7);
        assertEquals("PRIME\n", outputStream.toString());
    }

    @Test
    public void testIsPrimeUP(){
        Solution testAnswer = new Solution();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);


        Solution.checkOperation(testAnswer.isPrime(), 14);
        assertEquals("COMPOSITE\n", outputStream.toString());
    }

    @Test
    public void testIsPrimeZero(){
        Solution testAnswer = new Solution();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);


        Solution.checkOperation(testAnswer.isPrime(), 0);
        assertEquals("NEITHER PRIME NOR COMPOSITE\n", outputStream.toString());
    }

    @Test
    public void testIsPalindromeHP(){
        Solution testAnswer = new Solution();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);

        Solution.checkOperation(testAnswer.isPalindrome(), 1);
        assertEquals("IS PALINDROME\n", outputStream.toString());
    }

    @Test
    public void testIsPalindromeUP(){
        Solution testAnswer = new Solution();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);

        Solution.checkOperation(testAnswer.isPalindrome(), 12324234);
        assertEquals("NOT PALINDROME\n", outputStream.toString());
    }

}