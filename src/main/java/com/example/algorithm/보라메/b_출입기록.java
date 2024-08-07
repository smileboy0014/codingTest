package com.example.algorithm.보라메;

import java.io.*;
import java.util.*;

public class b_출입기록 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, ans;

    static Map<Integer, Integer> records = new HashMap();
    static void input(){
        N = scan.nextInt();

        for(int i = 0; i< N; i++){
            String[] lines = scan.nextLine().split(" ");
            Integer person = Integer.valueOf(lines[0]);
            Integer bol = Integer.valueOf(lines[1]);

             if (!records.containsKey(person) && bol == 0) {
                ans++;
            }
            else if(records.containsKey(person)){
                if(records.get(person) == 0 && bol == 0){
                    ans++;
                }else if(records.get(person) == 1 && bol == 1){
                    ans++;
                }
             }
            records.put(person,bol);
        }

        for(Integer key : records.keySet()){
            if(records.get(key) == 1) ans++;
        }
    }

    static void pro() {

        System.out.println(ans);
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
