package com.example.algorithm.보라메;

import java.io.*;
import java.util.StringTokenizer;

public class a_특식배부 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, A, B, C, ans;

    static int[] chicken;
    static void input(){
        N = scan.nextInt();
        chicken = new int[3];
        for(int i = 0; i< 3; i++) chicken[i] = scan.nextInt();

    }

    static void pro() {
        for(int i = 0; i < 3; i++){
            int c = Math.min(N, chicken[i]);
            ans += c;
        }
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
