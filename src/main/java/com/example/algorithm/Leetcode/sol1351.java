package com.example.algorithm.Leetcode;

public class sol1351 {
    public static void main(String[] args) {
        System.out.println(countNegatives(new int[][]{{1,0},{1,-1},{3,-5}}));
    }

    public static int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int row = 0;
        int col = grid[0].length - 1;
        int count = 0;

        while(row < rows && col >= 0){
            if(grid[row][col] >= 0){
                row++;
            } else {
                count += rows - row;
                col--;
            }
        }

        return count;

    }
}
