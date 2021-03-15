package com.cdemarti.w1.q2;

import java.util.Arrays;

public class RightMost {
    Integer[] list;

    RightMost(Integer[] list){
        this.list = list;
    }


    public Integer[] createNewArray(Integer[] old){
        return Arrays.stream(old)
                .map( num -> num % 10 )
                .toArray(Integer[]::new);
    }
}
