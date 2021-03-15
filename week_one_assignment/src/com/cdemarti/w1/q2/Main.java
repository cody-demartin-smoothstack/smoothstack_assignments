package com.cdemarti.w1.q2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 33, 567};
        RightMost testOne = new RightMost(numbers);

        Integer[] result = testOne.createNewArray(testOne.list);
        System.out.println(Arrays.asList(result));
    }


}
