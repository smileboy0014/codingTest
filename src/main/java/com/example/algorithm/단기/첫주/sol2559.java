package com.example.algorithm.단기.첫주;

import java.io.*;
import java.util.StringTokenizer;

public class sol2559 {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {

        //슬라이딩 윈도우로 gogo
        int n = scan.nextInt();
        int limit = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }


        int p1 = 0;
        int p2 = 1;
        int sum = arr[p1];
        int nowCnt = 1;
        int maxVal = Integer.MIN_VALUE; // Edge Case: -100 -100 이럴때 주의!!!

        while (p2 < n) {
            // p2를 최대한 땡김
            while (nowCnt < limit) {
                sum += arr[p2];
                nowCnt++;
                p2++;
            }
            maxVal = Math.max(maxVal, sum);
            sum -= arr[p1++];
            nowCnt--;
        }

        System.out.println(maxVal);

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
