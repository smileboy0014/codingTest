package com.example.algorithm.단기.둘쨰주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class sol2178 {
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);
        int[][] matrix = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(dist, matrix, visit);

        System.out.println(dist[n-1][m-1]);
    }

    private static void bfs(int[][] dist, int[][] matrix,boolean[][] visit) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        dist[0][0] = 1;
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int k = 0; k < 4; k++) {
                int dx = temp[0]+dir[k][0];
                int dy = temp[1]+dir[k][1];

                if(dx < 0 || dy < 0 || dx >= matrix.length || dy >= matrix[0].length) continue;
                if(matrix[dx][dy] == 0) continue;
                if (!visit[dx][dy]) {
                    visit[dx][dy] = true;
                    dist[dx][dy] += dist[temp[0]][temp[1]]+1;
                    q.add(new int[]{dx, dy});
                }
            }

        }
    }
}
