package com.example.algorithm.Leetcode;

public class sol2500 {
    public static void main(String[] args) {
        System.out.println(deleteGreatestValue(new int[][]{{1,2,4},{3,3,1}}));
    }

    public  static int deleteGreatestValue(int[][] grid) {
        // [[1,2,4],[3,3,1]]
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int k = 0; k < m; k++){
            int maxVal = 0;
            for(int i = 0; i < m; i++){
                int maxVal2 = 0;
                int targetIdx = 0;
                for(int j = 0 ; j < n; j++){
                    if(maxVal2 <= grid[i][j]){
                        maxVal2 = grid[i][j];
                        targetIdx = j;
                    }

                }
                System.out.println("maxVal2 "+maxVal2);
                grid[i][targetIdx] = 0;
                maxVal = Math.max(maxVal, maxVal2);
            }
            ans += maxVal;
        }

        return ans;
    }
}
