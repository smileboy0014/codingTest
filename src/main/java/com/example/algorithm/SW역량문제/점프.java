package com.example.algorithm.SW역량문제;

import java.io.*;
import java.util.StringTokenizer;

public class 점프 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] Matrix;
    static long[][] Dy;
    static void input(){
        N = scan.nextInt();
        Matrix = new int[N + 1][N+1];
        // 경우의 수가 2^64-1 이므로 long 범위로 지정!!!
        Dy = new long[N + 1][N+1];

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                Matrix[i][j] = scan.nextInt();
            }
        }

    }

    // Dy[i][j]는 (i,j)에 가는 최소 경로 수
    static void pro() {
        // 초기값 구하기
        Dy[1][1] = 1;
        // 점화식을 토대로 Dy 배열 채우기
        for(int i = 1; i<=N; i++) {
            for(int j = 1; j<=N; j++) {
                int next = Matrix[i][j];
                // 탈출 조건에 만족 했을 때
                if(next == 0) break;
                // 밑으로 갈 때
                if(i+next <= N) Dy[i+next][j] +=Dy[i][j];
                // 오른쪽으로 갈 떄
                if(j+next <= N) Dy[i][j+next] +=Dy[i][j];
            }
        }
        // Dy 배열로 정답 계산하기
        System.out.println(Dy[N][N]);
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
