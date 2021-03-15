package com.cdemarti.dayfive.question2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Comma {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Comma test = new Comma();

        System.out.println(test.addToInteger(numbers));
    }

    public String addToInteger(List<Integer> data){
        List<String> alteredNumbers = data.stream()
                .map( (integer) -> {
                    if(integer % 2 == 0){
                        return "e" + integer;
                    }
                    else{
                        return "o" + integer;
                    }
                })
                .collect(Collectors.toList());

        return String.join(", ", alteredNumbers);
    }
}
