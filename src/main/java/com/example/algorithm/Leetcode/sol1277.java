package com.example.algorithm.Leetcode;

public class sol1277 {

    public static void main(String[] args) {
        System.out.println(countSquares(new int[][]{{1,0,1},{1,1,0},{1,1,0}}));
    }

        public static int countSquares(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            int[][] dp = new int[n+1][m+1];
            int result = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    dp[i][j] = matrix[i][j];
                }
            }

            for(int i = 1; i < n; i++){
                for(int j = 1; j < m; j++){
                    if(dp[i][j] == 1){
                        int min = Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1]));
                        dp[i][j] = min + 1;
                    }
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    result += dp[i][j];
                }
            }

            return result;
        }

}
