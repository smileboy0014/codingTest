package com.example.algorithm.단기.둘쨰주;

import java.util.Scanner;

public class sol10709 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] matrix = new int[n][m];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = scan.next();
            char[] chars = line.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char ch = chars[j];
                if (ch == 'c') {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    int idx = 1;
                    while (j < m - 1) {
                        if (matrix[i][j + 1] == 0) {
                            break;
                        }
                        matrix[i][++j] = idx++;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
