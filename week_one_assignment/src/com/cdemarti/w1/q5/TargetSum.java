package com.cdemarti.w1.q5;

public class TargetSum {

    public static void main(String[] args) {
        TargetSum test = new TargetSum();
        int start = 0;
        int[] nums = {1, 1, 67};
        int target = 2;

        System.out.println(test.groupSumClump(start, nums, target));
    }

    public boolean groupSumClump(int start, int[] nums, int target) {

        // base cases. we are going to be subtracting from the target if we use a grouping
        // if it eventually reaches 0, we can conclude we are able to use a path and return the number
        if (target == 0) return true;
        if(start >= nums.length) return false;

        // we make end our start at first, as even a group of one integer should be considered
        int end = start;

        // while end is less than the length of the array, and the initial group identifier remains consistent,
        // we increment end
        while(end < nums.length && nums[end] == nums[start]) end++;

        // after we escape the loop, we take the difference of the initial index and the new end index
        // this is how many duplicate values of the initial identifier we found
        int length = end - start;

        // we either don't use this group, and continue on, or we use the group, subtracting its value from the total
        // whichever path gets evaluated to true is the path we pick
        return groupSumClump(end, nums, target) ||
                groupSumClump(end, nums, target - nums[start]*length);
    }
}
