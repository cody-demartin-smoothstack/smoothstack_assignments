package com.cdemarti.dayfive.question3;

import java.util.List;
import java.util.stream.Collectors;

public class LengthAndChar {
    public static List<String> threeLetterStartWithA(List<String> data){
        return data.stream()
                .filter(str -> (str.length() == 3 && (str.charAt(0) == 'a') || str.charAt(0) == 'A'))
                .collect(Collectors.toList());
    }
}
