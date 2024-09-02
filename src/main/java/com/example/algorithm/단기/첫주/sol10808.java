package com.example.algorithm.단기.첫주;

import java.io.*;
import java.util.StringTokenizer;

public class sol10808 {
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        String str = scan.next();
        StringBuilder sb = new StringBuilder();
        int[] chars = new int[26];

        for(int i = 0; i< str.length(); i++){
            char ch = str.charAt(i);
            chars[ch-'a'] ++;
        }

        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]).append(" ");
        }




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
