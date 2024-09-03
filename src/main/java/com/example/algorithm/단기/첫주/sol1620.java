package com.example.algorithm.단기.첫주;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class sol1620 {


    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        // Map 2개로 풀면 되지 않을까?
        int n = scan.nextInt();
        int m = scan.nextInt();
        StringBuilder sb = new StringBuilder();

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        int idx = 1;
        for (int i = 0; i < n; i++) {
            String name = scan.next();
            map1.put(idx, name);
            map2.put(name, idx);
            idx++;
        }
        // 문제 맞추기
        String nums = "0123456789";
        for (int i = 0; i < m; i++) {
            String problem = scan.next();
            if (nums.contains(String.valueOf(problem.charAt(0)))) { // 숫자면
                sb.append(map1.get(Integer.parseInt(problem))).append("\n");
            } else { //문자면
                sb.append(map2.get(problem)).append("\n");
            }

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
