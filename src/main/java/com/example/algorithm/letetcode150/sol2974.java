package com.example.algorithm.letetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class sol2974 {

    public static void main(String[] args) {
        System.out.println(numberGame(new int[]{5,4,2,3}));
    }

    public static int[] numberGame(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i+=2) {
            int num1 = nums[i];
            int num2 = nums[i+1];
            int temp = num1;

            num1 = num2;
            num2 = temp;

            ans[i] = num1;
            ans[i + 1] = num2;
        }

        return ans;
    }
}
