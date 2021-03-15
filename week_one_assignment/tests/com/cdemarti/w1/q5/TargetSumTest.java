package com.cdemarti.w1.q5;

import org.junit.Test;

import static org.junit.Assert.*;

public class TargetSumTest {

    @Test
    public void testHappy(){
        TargetSum test = new TargetSum();
        int start = 0;
        int[] nums = {1, 1, 67};
        int target = 2;

        assertTrue(test.groupSumClump(start, nums, target));
    }

    @Test
    public void testUnhappy(){
        TargetSum test = new TargetSum();
        int start = 0;
        int[] nums = {1, 1, 1};
        int target = 2;

        assertFalse(test.groupSumClump(start, nums, target));
    }

    @Test
    public void testHappyFromSecondIndex(){
        TargetSum test = new TargetSum();
        int start = 1;
        int[] nums = {1, 1, 1};
        int target = 2;

        assertTrue(test.groupSumClump(start, nums, target));
    }

}