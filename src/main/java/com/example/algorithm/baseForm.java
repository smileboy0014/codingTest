package com.example.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baseForm {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static void input(){

    }

    static void pro() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(6);
        arr.add(5);
        arr.add(1);
        arr.add(5);
        arr.add(2);
        arr.remove(0);
        int[] psum = new int[arr.size()];
        for(int i = 1; i<= arr.size(); i++){
            int sum = 0;
            for(int j = 0; j < i; j++){
                sum += arr.get(j);
            }
            psum[i-1] = sum;
        }
        long answer = 0;
        for(int i = 0; i < psum.length; i++){
            int num = psum[i];
            if(i%2 == 0){
                answer += num;
            } else {
                answer -= num;
            }
        }


        System.out.println("answer = " + answer);
    }
    public static void main(String[] args) {
        input();
        pro();
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
