package com.example.algorithm.백준;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 은행털자1 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;

    static HashMap<Integer,Long> map;
    static void input(){
        N = scan.nextInt();
        map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String[] lines = scan.nextLine().split(" ");
            int X = Integer.parseInt(lines[0]);
            int T = Integer.parseInt(lines[1]);
            int C = Integer.parseInt(lines[2]);
            int X_T = T-X;

            if(map.containsKey(X_T)){
               map.put(X_T, map.getOrDefault(X_T, 0L)+C);
            } else {
                map.put(X_T, (long) C);
            }
        }
    }

    static void pro() {
        System.out.println(Collections.max(map.values()));;
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
