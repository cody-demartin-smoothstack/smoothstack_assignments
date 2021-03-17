package com.cdemarti.w1.q1;

public class Solution {

    /**
     * Method to assign a particular lambda to a given number
     * @param func Some implementation of functional interface
     * @param num Some integer number
     */
    public static void checkOperation(PerformOperation func, int num){
        func.calculate(num);
    }


    /**
     * A lambda used for determining even or odd
     * @return A lambda function
     */
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

    /**
     * Implementation of functional interface to determine if a number is
     * prime or not
     * @return A lambda function that determines a number's primeness
     */
    PerformOperation isPrime(){
        PerformOperation primeOrComposite = (num) -> {
            if (num <= 1) System.out.println("NEITHER PRIME NOR COMPOSITE");
            else {
                boolean state = false;
                for (int i = 2; i < num / 2; i++){
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


    /**
     * Determines whether a given integer is a palindrome or not
     * @return a Lambda function that determines palindrome or not
     */
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
