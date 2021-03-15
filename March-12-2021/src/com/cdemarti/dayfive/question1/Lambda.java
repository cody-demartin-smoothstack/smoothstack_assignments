package com.cdemarti.dayfive.question1;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda {

    public static void main(String[] args) {
        List<String> data =Arrays.asList("hellllloooo", "hello", "hi", "World:)", "end");
        Lambda testOne = new Lambda();

        System.out.println(testOne.lengthAscending(data));
        System.out.println(testOne.lengthDescending(data));
        System.out.println(testOne.firstChar(data));
        System.out.println(testOne.firstCharE(data));
    }

    public List<String> lengthAscending(List<String> data) {
        data.sort((s1, s2) -> s1.length() - s2.length());
        return data;
    }

    public List<String> lengthDescending(List<String> data) {
        data.sort((s1, s2) -> s2.length() - s1.length());
        return data;
    }

    public List<String> firstChar(List<String> data) {
        data.sort((s1, s2) -> s1.charAt(0) - s2.charAt(0));
        return data;
    }

    public List<String> firstCharE(List<String> data) {
        Collections.sort(data, Comparator.comparing(string -> !string.startsWith("e")));
        return data;
    }

}
