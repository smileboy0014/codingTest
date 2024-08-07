package com.example.algorithm.보라메;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class e_조교의맹연습 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, ans;

    static int[] values;
    // 우, 좌, 뒤
    static int[] dir = new int[]{3,1,2};

    // (i, j) , i: 소모하는 에너지, j : 방향    -> dp[K][0] 값을 구하면 됨!!!!
    static int[][] dp;

    static void input(){
        values = new int[3];
        for(int i = 0; i< 3; i++){
            values[i] = scan.nextInt();
        }
        K = scan.nextInt();
    }


    static void pro() {
        dp = new int[K+1][4];

        for(int i=0; i<=K; i++) {
            Arrays.fill(dp[i], 1000001);
        }

        //초기값 세팅
        dp[0][0] = 0;

        for(int i=0; i<=K; i++) {
            for(int j=0; j<4; j++) {
                if(dp[i][j] == 1000001) continue;
                for(int c=0; c<3; c++) {
                    if(i+values[c] > K) continue;
                    dp[i + values[c]][(j + dir[c]) % 4] = Math.min(dp[i + values[c]][(j + dir[c]) % 4], dp[i][j] + 1);
                }
            }
        }

        if(dp[K][0] == 1000001) dp[K][0] = -1;
        System.out.println(dp[K][0]);

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
