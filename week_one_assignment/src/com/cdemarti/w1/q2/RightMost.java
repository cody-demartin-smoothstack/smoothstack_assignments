package com.cdemarti.w1.q2;


import java.util.List;
import java.util.stream.Collectors;

public class RightMost {
    List<Integer> list;

    RightMost(List<Integer> list){
        this.list = list;
    }


    public List<Integer> createNewArray(List<Integer> old){
        return old.stream()
                .map( num -> num % 10 )
                .collect(Collectors.toList());
    }
}
