package com.example.algorithm.경진대회1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드뒤집기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;

    static int[] card;

    static boolean[] selected, used;
    static void input(){

        N = scan.nextInt();
        card = new int[N+1];
        selected = new boolean[N+1];
        used= new boolean[N+1];

    }

    static void check(){
        Queue<Integer> Q = new LinkedList<>();

        for(int i = 1; i <=N ; i++){
            Q.add(card[i]);
            used[i] = true;

            // BFS 과정
            while(!Q.isEmpty()){
                int card = Q.poll();

                    int left = i-card;
                    int right = i+card;
                    if(left < 1 && right > N) {

                    }
//                    if(used[][ny]) continue;
//                    if(A[nx][ny] != 0) continue;
//                    Q.add(nx);
//                    visited[nx][ny] = true;

                }
        }




    }

    static void dfs(int k) {

        if(k == N+1){
            check();
        } else {
            for(int i = 1; i<= N; i++){
                if(selected[i]) continue;
                selected[i] = true;
                card[k] = i;
                dfs(k+1);
                selected[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        input();
        dfs(1);
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
