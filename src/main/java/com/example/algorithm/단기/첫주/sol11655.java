package com.example.algorithm.단기.첫주;

import java.io.*;
import java.util.StringTokenizer;

public class sol11655 {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        String str = scan.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (65 <= ch && ch <= 90) { // A ~ Z 65 ~ 90
                int temp = (ch + 13);
                if (temp > 90) {
                    temp = temp-90+64;
                }
                sb.append((char)temp);
            } else if (97 <= ch && ch <= 122) { // a ~ z 97 ~ 122
                int temp = (ch + 13);
                if (temp > 122) {
                    temp = temp - 122 + 96;
                }
                sb.append((char)temp);
            } else {
                sb.append(ch);
            }

        }

        System.out.println(sb);
//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
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
