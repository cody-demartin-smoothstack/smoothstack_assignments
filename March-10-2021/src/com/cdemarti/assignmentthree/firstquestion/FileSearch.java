package com.cdemarti.assignmentthree.firstquestion;


import java.io.File;
import java.util.Scanner;

public class FileSearch {
    public static void main(String[] args) {
        System.out.println("Please enter a directory absolute path:");
        Scanner input = new Scanner(System.in);

        String mainPath = input.nextLine();
        FileSearch search = new FileSearch();
        File mainDirectory = new File(mainPath);

        if(mainDirectory.exists() && mainDirectory.isDirectory()){
            File arr[] = mainDirectory.listFiles();

            System.out.println("Files from directory: " + mainPath);
            search.printFiles(arr, 0, 0);
        }
    }

    private void printFiles(File[] arr, int index, int level){

        if(index == arr.length)
            return;

        for (int i =0; i < level; i++){
            System.out.print("\t");
        }

        if(arr[index].isFile()){
            System.out.println(arr[index].getName());
        }
        else if(arr[index].isDirectory()){
            System.out.println("(" + arr[index].getName() + ")" + " - Directory");
            printFiles(arr[index].listFiles(), 0, level + 1);
        }

        printFiles(arr, ++index, level);
    }
}
