package com.example.algorithm.SW역량문제;

import java.io.*;
import java.util.StringTokenizer;

public class 계단오르기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] Dy;
    static int[] A;
    static void input(){
        N = scan.nextInt();
        A = new int[N + 1];
        Dy = new int[N + 1][2];
        for (int i = 1; i <= N; i++){
            A[i] = scan.nextInt();
        }

    }

    // Dy[][] 를 미리 계산해 놓기
    // Dy[i][0] i-1 계단을 밟지 않고 계단에서 올 때
    // Dy[i][1] i-1 계단을 밟고 계단에서 올 때
    static void pro() {
        // 초기값 구하기
        Dy[1][0] = 0;
        Dy[1][1] = A[1];

        if(N >= 2){
            Dy[2][0] =A[2];
            Dy[2][1] =A[1]+A[2];
        }

        // 점화식을 토대로 Dy 배열 채우기
        for(int i = 3; i<=N; i++) {
            Dy[i][0] = Math.max(Dy[i-2][0]+A[i],Dy[i-2][1]+A[i]);
            Dy[i][1] = Dy[i-1][0] + A[i];

        }

        // Dy배열로 정답 계산하기
        int ans = Math.max(Dy[N][0], Dy[N][1]);

        System.out.println(ans);
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
