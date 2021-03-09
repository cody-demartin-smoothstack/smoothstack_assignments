package com.cdemarti.assignmentone.firstquestion;

public class QuestionOne {
    static int dots = 9;
    static int question = 1;

    public void pyramidOne() {
        int i, j;
        System.out.println(question + ")");
        question++;

        for (i = 0; i < 4; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        printDots();
        dots++;
    }

    public void pyramidTwo(){
        int i, j;
        System.out.println(question + ")");
        question++;
        printDots();
        dots++;

        for (i = 4; i >= 1; i--) {
            for (j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void pyramidThree(int n) {
        int rows, spaces, stars;
        System.out.println(question + ")");
        question++;

        for (rows = 1; rows <= n; rows++){
            for (spaces = 1; spaces <= (n*2) - rows; spaces++){
                System.out.print(" ");
            }
            for (stars = 1; stars <= (rows * 2) - 1; stars++){
                System.out.print("*");
            }
            System.out.println();
        }

        printDots();
        dots++;
    }

    public void pyramidFour(int n) {
        int rows, spaces, stars;
        System.out.println(question + ")");
        question++;
        printDots();
        dots++;

        for (rows = 1; rows <= n; rows++){
            for (spaces = 0; spaces < rows; spaces++){
                System.out.print(" ");
            }
            for (stars = ((n*2) - 1) - 2*(rows - 1); stars > 0; stars--){
                System.out.print("*");
            }
            System.out.println();
        }

    }



    private void printDots(){
        for (int i = 0; i < dots; i++) {
            System.out.print(". ");
        }
        System.out.println();
    }
}
