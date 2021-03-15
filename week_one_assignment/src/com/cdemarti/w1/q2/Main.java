package com.cdemarti.w1.q2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 33, 567);
        RightMost testOne = new RightMost(numbers);


        System.out.println(testOne.createNewArray(numbers));
    }


}
