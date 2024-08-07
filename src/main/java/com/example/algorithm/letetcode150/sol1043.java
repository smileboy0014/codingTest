package com.example.algorithm.letetcode150;

public class sol1043 {

    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3},4));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int length = arr.length;
        int[] dp = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            int max = 0;
            int sum = 0;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                max = Math.max(max, arr[i - j]);
                sum = Math.max(sum, (max * j) + dp[i - j]);
            }
            dp[i] = sum;
        }
        return dp[length];
    }
}
