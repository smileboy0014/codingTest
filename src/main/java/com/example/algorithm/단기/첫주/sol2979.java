package com.example.algorithm.단기.첫주;

import java.io.*;
import java.util.StringTokenizer;

public class sol2979 {
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        int a = scan.nextInt(); //5
        int b = scan.nextInt(); //3
        int c = scan.nextInt(); //1

        int[][] range = new int[3][2];
        int max = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                range[i][j] = scan.nextInt();
                max = Math.max(max, range[i][j]);
            }
        }

        int idx = 1;

        while (idx <= max) {
            int duplicate = 0;
            for (int[] ints : range) {
                if (ints[0] <= idx && idx < ints[1]) {
                    duplicate++;
                }
            }
            if (duplicate == 1) {
                ans += a;
            } else if (duplicate == 2) {
                ans += b*2;
            } else if (duplicate == 3) {
                ans += c*3;
            }
            idx++;
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
