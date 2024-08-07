package com.example.algorithm.프로그래머스.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_stack3 {

    static double Solution(int[] nums) {

        int leftSum = 0;
        int rightSum = 0;
        int idx = 0;

        for(int i = 0; i < nums.length; i++){
            leftSum = 0;
            rightSum = 0;
            for(int j = 0; j < i; j++) leftSum += nums[j];
            for(int k = i+1; k < nums.length; k++) rightSum+= nums[k];

            if(leftSum == rightSum) return i;
        }

        return -1;

    }


    public static void main(String[] args) {
        System.out.println(Solution(new int[]{1,7,3,6,5,6}));
    }
}
