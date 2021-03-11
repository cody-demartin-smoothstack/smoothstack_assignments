package com.cdemarti.assignmentthree.questionthree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CharacterCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CharacterCounter counter = new CharacterCounter();

        System.out.println("Please enter an absolute path to a file name:");
        String file = input.nextLine();


        System.out.println("Please enter a character to search the file for:");
        char target = input.next().charAt(0);

        char[] data = counter.readFile(file);
        int result = counter.counter(data, target);

        System.out.println(target + " appears " + result + " times.");
    }

    // /Users/codydemartin/Development/smoothstack_assignments/March-10-2021/Resources/output.txt

    public int counter(char[] arr, Character target){
        int counter = 0;
        for(Character c: arr){
            if (c == target){
                counter += 1;
            }
        }
        return counter;
    }

    public char[] readFile(String fileName){
        Path filePath = Path.of(fileName);
        StringBuilder output = new StringBuilder();
        try {
            output.append(Files.readString(filePath));

        } catch (IOException e){
            e.printStackTrace();
        }
        return output.toString().toCharArray();
    }
}
