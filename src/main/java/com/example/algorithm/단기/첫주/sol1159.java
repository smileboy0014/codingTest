package com.example.algorithm.단기.첫주;

import java.io.*;
import java.util.StringTokenizer;

public class sol1159 {
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        int n  = scan.nextInt();
        int[] chars = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char firstName = scan.next().charAt(0);
            chars[firstName - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 5) {
                sb.append((char)(i+'a'));
            }
        }


        System.out.println(sb.toString().equals("")  ? "PREDAJA" : sb);
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
