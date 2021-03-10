package com.cdemarti.assignmenttwo.secondquestion;

public class TwoDArray {

    /**
     * @author codydemartin
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 5, 6, 7, 92 }, { 3, 4, 100, 2, 1, 7 } };
        Integer max = Integer.MIN_VALUE;
        int first = 0, second = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if( arr[i][j] > max){
                    max = arr[i][j];
                    first = i;
                    second = j;
                }
            }
        }

        System.out.println("Max: " + max +" Location: (" + first + ", " + second + ")");
    }
}
