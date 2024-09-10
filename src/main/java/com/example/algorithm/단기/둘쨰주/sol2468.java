package com.example.algorithm.단기.둘쨰주;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sol2468 {
    static Scanner scan = new Scanner(System.in);
    static boolean[][] visit;
    static int[][] matrix;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        int n = scan.nextInt();
        int maxHeight = 0;
        matrix = new int[n][n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
                maxHeight = Math.max(maxHeight, matrix[i][j]);
            }
        }


        for (int h = 0; h < maxHeight+1; h++) {
            visit = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && (matrix[i][j] > h)) {
                        cnt += bfs(i, j, h, matrix);
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    private static int bfs(int x, int y, int maxHeight, int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int k = 0; k < 4; k++) {
                int dx = temp[0] + dir[k][0];
                int dy = temp[1] + dir[k][1];
                if (dx < 0 || dy < 0 || dx >= matrix.length || dy >= matrix[0].length) continue;
                if (visit[dx][dy]) continue;
                if (matrix[dx][dy] > maxHeight) {
                    visit[dx][dy] = true;
                    q.add(new int[]{dx, dy});
                }
            }
        }

        return 1;
    }
}
