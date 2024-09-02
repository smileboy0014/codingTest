package com.example.algorithm.단기.첫주;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sol10988 {
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        String str = scan.next();
        int ans = 1;
        int p1 = 0;
        int p2 = str.length() - 1;

        while (p1 <= p2) {
            if (str.charAt(p1) != str.charAt(p2)) {
                ans = 0;
                break;
            }
            p1++;
            p2--;
        }


        System.out.println(ans);
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
