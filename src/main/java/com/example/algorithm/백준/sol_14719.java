package com.example.algorithm.백준;

import java.io.*;
import java.util.StringTokenizer;

public class sol_14719 {
    static FastReader scan = new FastReader();

    public static void main(String[] args) {

        int y = scan.nextInt();
        int x = scan.nextInt();
        int result = 0;

        int[] matrix = new int[x];

        for (int i = 0; i < x; i++) {
            matrix[i] = scan.nextInt();
        }

        for (int i = 1; i < x-1; i++) {
           int leftH = 0;
           int rightH = 0;

            for (int j = 0; j < i; j++) {
                leftH = Math.max(matrix[j], leftH); // 현재 인덱스 기준 왼쪽 최고 높이 찾기
            }

            for(int j=(i+1); j<x; j++) {
                rightH = Math.max(matrix[j], rightH); // 현재 인덱스 기준 오른쪽 최고 높이 찾기
            }

            // 빗물이 고이기 위해선 현재 인덱스의 높이가 왼쪽 최고 높이와 오른쪽 최고 높이보다 작아야한다.
            // 빗물은 왼쪽, 오른쪽 중 최소 높이만큼은 찬다.
            if(matrix[i] < leftH && matrix[i] < rightH) result += Math.min(leftH, rightH) - matrix[i];

        }

        System.out.println(result);
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
