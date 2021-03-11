package com.cdemarti.assignmentthree.secondquestion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AppendText {

    public static void main(String[] args) {
        AppendText append = new AppendText();

        System.out.println("Please enter what you would like to add to the file.");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        append.write(text);
    }

    public void write(String input) {
        try (FileWriter fWriter = new FileWriter("Resources/output.txt", true)) {
            try (BufferedWriter bWriter = new BufferedWriter(fWriter)) {
                try (PrintWriter output = new PrintWriter(bWriter)) {
                    output.println(input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
