package com.cdemarti.w1.q1;

public class Main {
    public static void main(String[] args) {
        Solution answer = new Solution();

        int[][] testCases = {
                {1, 4},
                {2, 5},
                {3, 898},
                {1, 3},
                {2, 12}
        };

        for(int[] selection : testCases){
            if(selection[0] == 1){
                Solution.checkOperation(answer.isOdd(), selection[1]);
            }
            else if(selection[0] == 2){
                Solution.checkOperation(answer.isPrime(), selection[1]);
            }
            else if(selection[0] == 3){
                Solution.checkOperation(answer.isPalindrome(), selection[1]);
            }
            else{
                System.out.println("INVALID SELECTION");
            }
        }

    }


}
