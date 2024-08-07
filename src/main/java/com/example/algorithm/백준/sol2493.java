package com.example.algorithm.백준;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class sol2493 {
    static FastReader scan = new FastReader();


    public static void main(String[] args) {
        int n = scan.nextInt();
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = scan.nextInt();

            while (!stack.isEmpty()) {
                int[] data = stack.peek();
                int idx = data[0];
                int height = data[1];

                if (height > num) {
                    sb.append(idx + " ");
                    break;
                }
                stack.pop();

            }

            if (stack.isEmpty()) {
                sb.append(0 + " ");
            }

            stack.add(new int[]{i + 1, num});
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
