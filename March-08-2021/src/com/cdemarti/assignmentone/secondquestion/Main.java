package com.cdemarti.assignmentone.secondquestion;

import java.util.Scanner;

/**
 * @author codydemartin
 * User will guess a number from 1 - 100. If its within a certain range answer will be deemed correct.
 * User has 5 chances.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int random = randomNumber();

        for (int i = 0; i < 5; i++){
            System.out.print("Pick a number from 1 to 100: ");
            int prompt = scanner.nextInt();

            if (prompt >= random - 10 && prompt <= random + 10) {
                System.out.println("Close enough. Number was: " + random);
                System.exit(0);
            }
            System.out.println("Incorrect try again. " + (4-i) + " tries left.");
        }

        System.out.println("Sorry, the answer was: " + random);
        System.exit(0);
    }

    /**
     *
     * @return some random number
     */
    private static int randomNumber(){
        return (int)((Math.random() * 100) + 1);
    }
}

