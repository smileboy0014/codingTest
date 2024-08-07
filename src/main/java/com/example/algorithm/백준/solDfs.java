package com.example.algorithm.백준;

import java.io.*;
import java.util.StringTokenizer;

public class solDfs {

    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();
    static int N,M;
    static int[] selected;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
    }

    static void rec_fun(int k){
        if(k == M+1){
            for(int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            int start = selected[k-1];
            if(start == 0 ) start = 1;
            for(int cand = start; cand <=N; cand++){
                selected[k] = cand;
                rec_fun(k+1);
                selected[k] = 0;
            }
        }

    }


    public static void main(String[] args) {
        input();
        rec_fun(1);
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
                try{
                    st = new StringTokenizer(br.readLine());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
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
