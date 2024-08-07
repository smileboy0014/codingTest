package com.example.algorithm.경진대회1;

import java.io.*;
import java.util.StringTokenizer;

public class 인덕션 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, min_value, now_induction;

    static int[] temps, inductions;

    static void input() {
        N = scan.nextInt();
        temps = new int[N];
        inductions = new int[3];
        min_value = 0;
        now_induction = 0;
        for (int i = 0; i < N; i++) {
            temps[i] = scan.nextInt();
        }

    }

    static void pro() {

        for (int i = 0; i < N; i++) {
            for (int j = now_induction; j < 3; j++) {
                if (inductions[j] == 0) {
                    min_value += Math.min(Math.abs(10 - temps[i]), temps[i]);
                } else {
                    int new_touch = Math.min(Math.abs(10 - temps[i]), temps[i]);
                    min_value += Math.min(Math.abs(inductions[j] - temps[i]), new_touch);

                }
                inductions[j] = temps[i];
                if(now_induction < 2){
                    now_induction++;
                    break;
                }

            }
        }


        System.out.println(min_value);

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
