package com.example.algorithm.경진대회1;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class 탁구 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, D, P;

    static String[] score;
    static void input(){
        N = scan.nextInt();
        score = new String[N];
        for(int i = 0; i < N; i++) score[i] = scan.next();

    }

    static void pro() {

        for(int i = 0; i < N; i++){
            String now = score[i];

            if(now.equals("D")){
                D++;
            }else {
                P++;
            }

            if(Math.abs(D-P) >= 2) break;
        }
        sb.append(D).append(":").append(P);
    }
    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
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
