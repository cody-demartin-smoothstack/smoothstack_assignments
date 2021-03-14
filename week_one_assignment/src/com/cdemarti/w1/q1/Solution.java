package com.cdemarti.w1.q1;

import java.sql.SQLOutput;

public class Solution {

    public static void checkOperation(PerformOperation func, int num){
        func.calculate(num);
    }

    PerformOperation isOdd(){
        PerformOperation oddOrEven = (num) -> {
            if( num == 0) System.out.println("NUMBER IS ZERO; NOT ODD OR EVEN");
            else{
                if(num % 2 == 1) {
                    System.out.println("ODD");
                }
                else {
                    System.out.println("EVEN");
                }
            }
        };
        return oddOrEven;
    }

    PerformOperation isPrime(){
        PerformOperation primeOrComposite = (num) -> {
            if (num <= 1) System.out.println("NEITHER PRIME NOR COMPOSITE");
            else {
                boolean state = false;
                for (int i = 2; i < num / 2 + 1; i++){
                    if((num % i) == 0){
                        state = true;
                        break;
                    }
                }
                if (!state) {
                    System.out.println("PRIME");
                }
                else{
                    System.out.println("COMPOSITE");
                }
            }
        };

        return primeOrComposite;
    }

    PerformOperation isPalindrome(){
        PerformOperation isPalindromeOrNot = (num) -> {
            String stringValue = String.valueOf(num);
            if (stringValue.equals(new StringBuilder(stringValue).reverse().toString())){
                System.out.println("IS PALINDROME");
            }
            else {
                System.out.println("NOT PALINDROME");
            }
        };

        return isPalindromeOrNot;
    }
}
