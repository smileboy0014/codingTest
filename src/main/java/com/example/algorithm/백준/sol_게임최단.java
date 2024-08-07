package com.example.algorithm.백준;

import java.util.LinkedList;
import java.util.Queue;

public class sol_게임최단 {
    static int n, m;
    static int[][] dist;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }

    public static int solution(int[][] maps) {
        // int answer = 0;
        n = maps.length;
        m = maps[0].length;
        dist = new int[n][m];
        visit = new boolean[n][m];

        bfs(maps);

        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1]+1;
    }


    private static void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int k = 0; k < 4; k++) {
                int dx = temp[0] + dir[k][0];
                int dy = temp[1] + dir[k][1];

                if (dx < 0 || dy < 0 || dx >= n || dy >= m) continue;
                if (maps[dx][dy] == 0) continue;
                if (visit[dx][dy]) continue;

                visit[dx][dy] = true;
                q.add(new int[]{dx, dy});
                dist[dx][dy] = dist[temp[0]][temp[1]] + 1;
            }
        }


    }
}
