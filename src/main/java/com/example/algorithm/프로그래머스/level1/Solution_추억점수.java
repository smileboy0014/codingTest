package com.example.algorithm.프로그래머스.level1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution_추억점수 {
    static class Orange{
        int r;
        int c;
        int t;

        public Orange(int r, int c, int t){
            this.r = r;
            this.c = c;
            this.t = t;

        }
    }
    static int N, M,result, rotCnt, freshCnt;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][] visit;
    static Queue<Orange> q;

    static int Solution(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        result = 0;
        rotCnt = 0;
        freshCnt = 0;

        q = new LinkedList<>();
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] == 2){
                    q.add(new Orange(i,j,0));
                    visit[i][j] = true;
                } else if(grid[i][j] == 1){
                    freshCnt++;
                }
            }
        }

        bfs();
        System.out.println("freshCnt "+freshCnt);
        System.out.println("rotCnt "+rotCnt);
        System.out.println("result "+result);
        if(freshCnt != rotCnt) return -1;
        return result;

    }

    static void bfs() {

        while (!q.isEmpty()) {
            Orange orange = q.poll();

            int x = orange.r;
            int y = orange.c;
            int time = orange.t;
            result = Math.max(result, time);

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                rotCnt++;
                q.add(new Orange(nx, ny, time + 1));
            }


        }
    }

    public static void main(String[] args) {
        System.out.println(Solution(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
}
