package com.example.algorithm.단기.첫주.셋째날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sol10709 {

    public static void main(String[] args) throws IOException {
        // 1. 배열을 그린다.
        // 2. 움직임을 묘사한다. (어떻게?? 슬라이딩 윈도우??)

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[][] matrix = new int[M][N];

        for(int i = 0; i < M; i++){
            Arrays.fill(matrix[i], -1);
        }

        //초기 matrix 완성
        for (int i = 0; i < M; i++) {
            char[] chars = bf.readLine().toCharArray(); // c . . c
            for (int j = 0; j < N; j++) {
                char ch = chars[j];
                if (ch == 'c') {
                    matrix[i][j] = 0;
                }
            }
        }
        //구름 이동 시키기
        for (int i = 0; i < M; i++) {
            int idx = 0;
            while (idx < N) {
                while (idx < N && matrix[i][idx] != 0) {
                    idx++;
                }
                while (idx+1 < N && matrix[i][idx+1] != 0) {
                    matrix[i][idx+1] = matrix[i][idx]+1;
                    idx++;
                }
                idx++;
            }
        }
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
