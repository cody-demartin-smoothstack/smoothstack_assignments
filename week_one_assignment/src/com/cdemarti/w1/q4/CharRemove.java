package com.cdemarti.w1.q4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A class used to remove certain letters from a string list
 */

public class CharRemove {

    /**
     *
     * Driver method that shows example of removal of letter x
     */
    public static void main(String[] args) {
        List<String> test = Arrays.asList("ax", "bb", "cx");
        CharRemove testObj = new CharRemove();

        System.out.println(testObj.pruneString(test, "x"));
    }

    /**
     *
     * @param input some list of strings
     * @param letter some letter
     * @return returns the list with all instances of letter removed
     */
    public List<String> pruneString(List<String> input, String letter) {
        return input.stream()
                .map(str -> str.replaceAll(letter, ""))
                .collect(Collectors.toList());
    }
}
