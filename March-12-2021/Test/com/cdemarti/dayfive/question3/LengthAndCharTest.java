package com.cdemarti.dayfive.question3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class LengthAndCharTest {

    @Test
    public void threeLetterStartWithA() {
        List<String> testCase = Arrays.asList("ace", "aluminum", "Ace", "beef");
        List<String> expected = Arrays.asList("ace", "Ace").stream().collect(Collectors.toList());

        assertEquals(expected, LengthAndChar.threeLetterStartWithA(testCase));
    }
}