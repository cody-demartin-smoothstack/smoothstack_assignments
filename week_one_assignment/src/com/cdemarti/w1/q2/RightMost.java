package com.cdemarti.w1.q2;

import java.util.Arrays;
import java.util.List;

public class RightMost {
    Integer[] list;

    RightMost(Integer[] list){
        this.list = list;
    }


    public Integer[] createNewArray(Integer[] old){
        Integer[] result = Arrays.stream(old)
                .map( num -> num % 10 )
                .toArray(Integer[]::new);

        return result;
    }



}
