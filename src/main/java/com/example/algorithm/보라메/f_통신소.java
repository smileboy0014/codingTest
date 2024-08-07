package com.example.algorithm.보라메;

import java.io.*;
import java.util.*;

public class f_통신소 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, K, ans;
    static Com[] coms;

    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    static int[][] matrix;

    static class Com implements Comparable<Com>{
        int x;
        int y;
        int p;

        public Com(int x, int y, int p){
            this.x = x;
            this.y = y;
            this.p = p;

        }

        @Override
        public int compareTo(Com o) {
            return o.p- this.p;
        }
    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        matrix = new int[N+1][M+1];
        coms = new Com[K];
        for (int i = 0; i < K; i++) coms[i] = new Com(scan.nextInt(), scan.nextInt(), scan.nextInt());
        Arrays.sort(coms);
    }

    static void bfs(int origin_x, int origin_y, int p) {
        Queue<Integer> q = new LinkedList<>();
        q.add(origin_x);
        q.add(origin_y);
        matrix[origin_x][origin_y] = 1;

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if(matrix[nx][ny] == 1) continue;
                if(Math.abs(origin_x-nx)+Math.abs(origin_y-ny) <= p){
                    matrix[nx][ny] = 1;
                    q.add(nx);
                    q.add(ny);
                }
            }

        }

    }

    public static void main(String[] args) {
        input();
        for (Com c : coms) bfs(c.x, c.y, c.p);

        for(int[] row: matrix){
            for(int col:row){
                if(col == 1){
                    ans++;
                }
            }
        }

        System.out.println(ans);


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
