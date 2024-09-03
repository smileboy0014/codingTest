package com.example.algorithm.단기.첫주;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class sol9375 {


    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            Map<String, Integer> map = new HashMap<>(); //종류, 갯수
            for (int j = 0; j < n; j++) {
                String name = scan.next();
                String type = scan.next();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }


            int ans = 1;
            for (String key : map.keySet()) {
                Integer typeCnt = map.get(key);
                ans *= typeCnt + 1;

            }

            System.out.println(ans-1);

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
