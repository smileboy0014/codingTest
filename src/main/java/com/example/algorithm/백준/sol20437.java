package com.example.algorithm.백준;

import java.io.*;
import java.util.StringTokenizer;

public class sol20437 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] chars;
    static int minLen = 0;
    static int maxLen = 0;

    public static void main(String[] args) {

        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            findWord(scan.next(), scan.nextInt());
        }
        System.out.println(sb);


    }

    private static void findWord(String s, int k) {

        if (k == 1) {
            sb.append("1 1").append("\n");
        } else {
            minLen = Integer.MAX_VALUE;
            maxLen = Integer.MIN_VALUE;

            int l = s.length();
            chars = new int[27];

            for (char ch : s.toCharArray()) {
                chars[ch - 'a']++;
            }

            for (int i = 0; i < l; i++) {
                char ch = s.charAt(i);
                if (chars[ch - 'a'] < k) continue;
                int cnt = 1;
                for (int j = i + 1; j < l; j++) {
                    if (ch == s.charAt(j)) cnt++;
                    if (cnt == k) {
                        minLen = Math.min(minLen, j - i + 1);
                        maxLen = Math.max(maxLen, j - i + 1);
                        break;
                    }
                }
            }
            if (minLen == Integer.MAX_VALUE && maxLen == Integer.MIN_VALUE) {
                sb.append("-1").append("\n");
            } else {
                sb.append(minLen).append(" ").append(maxLen).append("\n");
            }


        }


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
