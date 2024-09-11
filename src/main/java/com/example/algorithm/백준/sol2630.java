package com.example.algorithm.백준;

import java.util.Scanner;

public class sol2630 {
    static Scanner scan = new Scanner(System.in);
    static int[][] matrix;
    static int whiteCnt;
    static int blueCnt;

    public static void main(String[] args) {
        // 하얀색은 0, 파란색인 1
        // 하얀색 갯수 \n 파란색 갯수
        int n = scan.nextInt();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        dfs(0, 0, n);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    private static void dfs(int x, int y, int size) {
        if (isPossible(x, y, size)) {
            if (matrix[x][y] == 0) {
                whiteCnt++;
            } else {
                blueCnt++;
            }
            return;
        }

        int newSize = size / 2;

        dfs(x, y, newSize);
        dfs(x, y+newSize, newSize);
        dfs(x+newSize, y, newSize);
        dfs(x+newSize, y+newSize, newSize);

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
