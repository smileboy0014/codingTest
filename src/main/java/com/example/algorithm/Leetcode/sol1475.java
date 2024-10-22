package com.example.algorithm.Leetcode;

public class sol1475 {
    public static void main(String[] args) {
        System.out.println(finalPrices(new int[]{8, 4, 6, 2, 3}));
    }

    public static int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int idx = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    idx = j;
                    break;
                }
            }
            if (idx == 0) {
                ans[i] = prices[i];
            } else {
                ans[i] = prices[i] - prices[idx];
            }
        }

        return ans;
    }
}
