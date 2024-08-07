package com.example.algorithm.백준;

import java.io.*;
import java.util.*;

public class 미세먼지안녕 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int R, C, T, sum;

    static int[][] A, spread_dust, A_copy;

    static ArrayList<Point> air_condition;

    // 아, 오, 위, 왼
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[] ccw = {1,2,3,0};
    static int[] cw = {1,0,3,2};

    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void input() {
        R = scan.nextInt();
        C = scan.nextInt();
        T = scan.nextInt();

        A = new int[R][C];

        air_condition = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String[] lines = scan.nextLine().split(" ");
            for (int j = 0; j < lines.length; j++) {
                if(Integer.parseInt(lines[j]) == -1){
                    air_condition.add(new Point(i,j));
                }
                A[i][j] = Integer.parseInt(lines[j]);
            }
        }
    }

    static void reset_val(){
        spread_dust = new int[R][C];
        A_copy = new int[R][C];
    }

    static void pro() {

        // T초 후 확인
        for (int t = 0; t < T; t++) {

            reset_val();

            // 미세먼지 확산
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (A[i][j] == 0 || A[i][j] == -1) continue;
                    dust_spread(i, j);
                }
            }
            // 한번에 퍼진 먼지 합산
            for(int i = 0; i < R; i++){
                for (int j = 0; j < C; j++) {
                    A[i][j] += spread_dust[i][j];
                    A_copy[i][j] = A[i][j];
                }
            }

            // 공기청정기 작동
            circulate(air_condition.get(0).x,air_condition.get(0).y,ccw);
            circulate(air_condition.get(1).x,air_condition.get(1).y,cw);

        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) {
                    sum += A[i][j];
                }
            }
        }

        System.out.println(sum);


    }

    static void circulate(int air_x, int air_y, int[] direction) {
        int x = air_x;
        int y = air_y+1;

        A[x][y] = 0;

        for(int d = 0; d < 4; d++){
            while(true){
                int nx = x + dir[direction[d]][0];
                int ny = y + dir[direction[d]][1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) break;
                if (air_x == nx && air_y == ny) break;
                A[nx][ny] = A_copy[x][y];
                x = nx;
                y = ny;
            }
        }


    }

    static void dust_spread(int x, int y) {

        int spread_cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];


            // 배열 범위가 벗어난 경우
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            // 공기청정기가 있는 경우
            if (A[nx][ny] == -1) continue;
            if(A[x][y] / 5 == 0) continue;
            // 퍼졌다면 +1
            spread_cnt++;
            spread_dust[nx][ny] += A[x][y] / 5;
        }

        // 퍼트린 먼저 크기 보정
        A[x][y] = A[x][y] - A[x][y] / 5 * spread_cnt;

    }

    public static void main(String[] args) {
        input();
        pro();
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
