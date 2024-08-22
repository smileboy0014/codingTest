package com.example.algorithm.Leetcode;

import java.util.Arrays;

public class sol338 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(11)));
    }


    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int offset = 1;
        for (int i = 1; i < ans.length; i++) {
            if (offset * 2 == i) {
                offset *= 2;
            }
            ans[i] = ans[i - offset] + 1;

        }
        return ans;
    }

}
