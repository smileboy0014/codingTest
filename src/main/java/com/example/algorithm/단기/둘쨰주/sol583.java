package com.example.algorithm.단기.둘쨰주;

import java.util.*;

public class sol583 {
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Scanner scan = new Scanner(System.in);
    static int[][] matrix;
    static boolean[][] visit;
    static List<Integer> list;

    public static void main(String[] args) {
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt(); // n x m 배열, k개의 사각형
        StringBuilder sb = new StringBuilder();

        matrix = new int[n][m];
        visit = new boolean[n][m];
        list = new ArrayList<>();

        for (int t = 0; t < k; t++) {
            int y1 = scan.nextInt();
            int x1 = scan.nextInt();
            int y2 = scan.nextInt();
            int x2 = scan.nextInt();

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    matrix[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && matrix[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");

        for (int l : list) {
            sb.append(l).append(" ");
        }

        System.out.println(sb);

    }

    private static void bfs(int x, int y) {
        int size = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int k = 0; k < 4; k++) {
                int dx = temp[0] + dir[k][0];
                int dy = temp[1] + dir[k][1];

                if(dx < 0 || dy < 0 || dx >= matrix.length || dy >= matrix[0].length) continue;
                if(matrix[dx][dy] == 1) continue;
                if (!visit[dx][dy]) {
                    visit[dx][dy] = true;
                    q.add(new int[]{dx, dy});
                    size++;
                }

            }
        }

        list.add(size);
    }
}
