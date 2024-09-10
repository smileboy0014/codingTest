package com.example.algorithm.단기.둘쨰주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class sol1012 {
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine()); //n m c

        while (t-- > 0) {
            String[] input = bf.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            int[][] matrix = new int[n][m];
            boolean[][] visit = new boolean[n][m];

            for (int i = 0; i < c; i++) {
                String[] s = bf.readLine().split(" ");
                matrix[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 1) {
                        ans++;
                        bfs(i, j, matrix, visit);
                    }
                }
            }
            System.out.println(ans);
        }

    }

    private static void bfs(int x, int y,int[][] matrix,boolean[][] visit) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int k = 0; k < 4; k++) {
                int dx = temp[0] + dir[k][0];
                int dy = temp[1] + dir[k][1];

                if (dx < 0 || dy < 0 || dx >= matrix.length || dy >= matrix[0].length) continue;
                if (matrix[dx][dy] == 0) continue;
                if (!visit[dx][dy]) {
                    visit[dx][dy] = true;
                    matrix[dx][dy] = 0;
                    q.add(new int[]{dx, dy});
                }
            }
        }


    }
}
