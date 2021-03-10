package com.cdemarti.assignmenttwo.firstquestion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * @author codydemartin
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number. When you are done entering numbers enter 0.");

        int number = -1;
        int sum = 0;
        do {
            try {
                number = input.nextInt();
                sum += number;
            } catch (InputMismatchException e) {
                System.out.println("Input a number.");
                input.next();
            }
        } while(number != 0);
        System.out.println("Your sum is: " + sum);
    }
}
