package com.example.algorithm.프로그래머스.스택;

public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                ans[i]++;
                if (prices[i] > prices[j])
                    break;

            }
        }
        System.out.println("ans = " + ans);


    }
}
