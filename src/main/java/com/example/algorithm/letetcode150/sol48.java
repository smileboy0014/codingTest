package com.example.algorithm.letetcode150;

public class sol48 {
    public static void main(String[] args) {
        System.out.println(rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }

    public static int rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            int head = 0;
            int tail = n - 1;
            while(head < tail){
                int temp = matrix[i][head];
                matrix[i][head] = matrix[i][tail];
                matrix[i][tail] = temp;
                head++;
                tail--;
            }
        }
        return 0;
    }
}
