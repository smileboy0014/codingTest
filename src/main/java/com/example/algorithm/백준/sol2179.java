package com.example.algorithm.백준;

import java.io.*;
import java.util.*;

public class sol2179 {
    static FastReader scan = new FastReader();


    public static void main(String[] args) {
        int n = scan.nextInt();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            list.add(scan.next());
        }

        String s = "";
        String t = "";
        int maxCnt = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String word1 = list.get(i);
            for (int j = i + 1; j < n; j++) {
                String word2 = list.get(j);
                int cnt = check(word1,word2);

                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    s = word1;
                    t = word2;
                }
            }
        }

        sb.append(s).append("\n").append(t);

        System.out.println(sb);
    }

    private static int check(String s1, String s2) {
        int minLength = Math.min(s1.length(),s2.length());
        int cnt = 0;
        for(int i = 0; i< minLength; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (ch1 == ch2) {
                cnt++;
            } else {
                break;
            }
        }

        return cnt;
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
