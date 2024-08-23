package com.example.algorithm.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class sol118 {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int l = numRows; //5
        int[][] dp = new int[l+1][l+1];
        for(int i = 1; i <= l; i++){
            dp[i][0] = 1;
            dp[i][i-1] = 1;
        }
        for(int i = 1;  i <= l; i++){
            for(int j = 1; j<= l; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        for(int i = 1;  i <= l; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j<= l; j++){
                if(dp[i][j] != 0) {
                    temp.add(dp[i][j]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
