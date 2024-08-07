package com.example.algorithm.경진대회1;

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class 현대모비스 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K, max_value,max_a_b,max_b_c,max_a_c;

    static Integer[] sums, selected;

    static Integer[] a,b,c, a_b, b_c, a_c;

    static boolean[] used;

    static Score[] scores;

    static class Score{
        int T;
        int A;
        int M;

    }

    static void input(){

        N = scan.nextInt();
        K = scan.nextInt();

        a = new Integer[N];
        b = new Integer[N];
        c = new Integer[N];
        a_b = new Integer[N];
        b_c = new Integer[N];
        a_c = new Integer[N];
        max_value = Integer.MIN_VALUE;

        for(int i = 0; i< N; i++){
          a[i] = scan.nextInt();
          b[i] = scan.nextInt();
          c[i] = scan.nextInt();
        }

    }

    // (a,b) (a,c) (b,c) 3가지 경우밖에 없다!!!!
    static void pro(){
        // a,b 를 고를 경우 a_b
        for(int i = 0; i <N; i++){
            a_b[i] = a[i]+b[i];
        }

        // a,c 를 고를 경우 a_c
        for(int i = 0; i <N; i++){
            a_c[i] = a[i]+c[i];
        }

        // b,c 를 고를 경우 b_c
        for(int i = 0; i <N; i++){
            b_c[i] = b[i]+c[i];
        }

        Arrays.sort(a_b, Collections.reverseOrder());
        Arrays.sort(a_c, Collections.reverseOrder());
        Arrays.sort(b_c, Collections.reverseOrder());

        for(int i = 0; i< K; i++){
            max_a_b += a_b[i];
        }

        for(int i = 0; i< K; i++){
            max_a_c += a_c[i];
        }

        for(int i = 0; i< K; i++){
            max_b_c += b_c[i];
        }

        max_value = Math.max(max_a_b,max_b_c);
        max_value = Math.max(max_value,max_a_c);


        System.out.println(max_value);

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
