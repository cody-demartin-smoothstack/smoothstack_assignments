package com.cdemarti.w1.q3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DoubleInteger {

    /**
     * Main driver method to return a list doubled both using a stream and iteratively
     * @param args args not used
     */
    public static void main(String[] args) {
        var testObj = new DoubleInteger();
        List<Integer> test = Arrays.asList(1, 2, 3);

        System.out.println(testObj.dub(test));
        System.out.println(testObj.doubling(test));
    }

    /**
     * Iteratively doubling the numbers in place without a stream
     * @param numbers a list of integers to be doubled
     * @return the old list now doubled
     */
    public List<Integer> doubling(List<Integer> numbers){
        numbers.replaceAll(num -> num * 2);
        return numbers;
    }

    /**
     * Doubling the list with an intermediate array using a stream
     * @param numbers a list of numbers to be doubled
     * @return The newly doubled list of numbers
     */
    public List<Integer> dub(List<Integer> numbers){
        return numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
    }
}
