package com.example.algorithm.백준;

import java.io.*;
import java.util.*;

public class sol16234 {

    static FastReader scan = new FastReader();
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int n, l, r, result;
    static boolean[][] visit;
    static int[][] matrix;
    static List<int[]> list;


    public static void main(String[] args) {
        n = scan.nextInt();
        l = scan.nextInt();
        r = scan.nextInt();

        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        move();

        System.out.println(result);
    }


    private static void move() {
        while (true) {
            visit = new boolean[n][n];

            boolean isMove = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        int sum = bfs(i, j);

                        if (list.size() > 1) {
                            isMove = true;
                            changePopulation(sum);
                        }
                    }

                }
            }
            if(!isMove) break;
            result++;
        }
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();
        int sum = matrix[x][y];

        q.add(new int[]{x, y});
        list.add(new int[]{x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int k = 0; k < 4; k++) {
                int dx = temp[0] + dir[k][0];
                int dy = temp[1] + dir[k][1];

                if(dx < 0 || dy < 0 || dx >= n || dy >= n) continue;
                if(visit[dx][dy]) continue;
                int t = Math.abs(matrix[temp[0]][temp[1]] - matrix[dx][dy]);
                if (l <= t && t <= r) {
                    visit[dx][dy] = true;
                    list.add(new int[]{dx, dy});
                    q.add(new int[]{dx, dy});
                    sum += matrix[dx][dy];
                }
            }
        }

        return sum;


    }

    private static void changePopulation(int sum) {
        int avg = sum / list.size();

        for (int[] ints : list) {
            int x = ints[0];
            int y = ints[1];

            matrix[x][y] = avg;
        }

    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
