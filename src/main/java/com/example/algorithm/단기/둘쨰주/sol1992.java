package com.example.algorithm.단기.둘쨰주;

import java.util.Scanner;

// https://st-lab.tistory.com/230
// 분할정복!!
public class sol1992 {
    static StringBuilder sb;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        matrix = new int[n][n];
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = scan.next();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }
        dfs(0, 0, n);
        System.out.println(sb);

    }

    private static void dfs(int x, int y, int size) {

        if (isPossible(x, y, size)) {
            sb.append(matrix[x][y]);
            return;
        }

        sb.append("(");
        int newSize = size / 2;

        dfs(x, y, newSize);
        dfs(x, y + newSize, newSize);
        dfs(x + newSize, y, newSize);
        dfs(x + newSize, y + newSize, newSize);

        sb.append(")");


    }

    private static boolean isPossible(int x, int y, int size) {
        int value = matrix[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (matrix[i][j] != value) {
                    return false;
                }
            }
        }

        return true;
    }
}
