package com.example.algorithm.단기.첫주.셋째날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol14502 {

    static int maxSize = 0;
    static int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {


        // 1. 메트릭스를 그린다.
        // 2. 3개의 벽을 세운다. -> 어떻게? -> bfs로??
        // 3. 바이러스를 퍼트려 본다.
        // 4. 안전지대 크기를 구한다.(최댓값으로!)

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // N x M
        String[] s1 = bf.readLine().split(" ");
        int N = Integer.parseInt(s1[0]);
        int M = Integer.parseInt(s1[1]);

        int[][] matrix = new int[N][M];
        boolean[][] visited = new boolean[N][M];


        for(int i = 0; i < N; i++){ //매트릭스 그리기
            String[] s2 = bf.readLine().split(" ");
            for(int j = 0; j < M; j++){
                matrix[i][j] = Integer.parseInt(s2[j]);
            }
        }





        System.out.println();
    }
}
