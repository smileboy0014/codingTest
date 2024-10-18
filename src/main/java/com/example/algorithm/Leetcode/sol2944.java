package com.example.algorithm.Leetcode;

import java.util.Arrays;

public class sol2944 {
    public static void main(String[] args) {
        System.out.println(minimumCoins(new int[]{1,10,1,1}));
    }

    public static int minimumCoins(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // dp[n] => the minimum cost of (n-1)th fruit

        for (int i = 0; i < n; i++) {
            // buyFruit is the cost of buying fruit at i(price[i])
            int buyFruit = dp[i] + prices[i];

            // consider i == 1 (the 2nd fruit),
            // we need to update dp[2] (if we buy the fruit)
            // and update the 2 free fruit which is dp[3], dp[4]
            // finally update the minimum cost of those influenced days

            // current buying fruit cost is at dp[i+1]
            // the free fruit is
            // from: dp[i+2] (free fruit start)
            // to: dp[(i+2) ---> start +
            // (i+1) ----------> total +
            // -1 -------------> tail])
            // thats the free fruit end index, we could simplify to (2*i+2)
            for (int j = i+1; j <= (2*i+2) && j <= n; j++) {
                dp[j] = Math.min(dp[j], buyFruit);
            }
        }
        return dp[n];
    }
}
