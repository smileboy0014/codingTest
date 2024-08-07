package com.example.algorithm.백준;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans;

    static int[][] matrix;

    static ArrayList<int[]> home, chicken;
    static boolean[] selected;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        ans = Integer.MAX_VALUE;
        matrix = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String[] lines = scan.nextLine().split(" ");
            for(int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(lines[j]);
                if(matrix[i][j] == 1){
                    home.add(new int[]{i,j});
                }

                if(matrix[i][j] == 2){
                    chicken.add(new int[]{i,j});
                }

            }
        }
        selected = new boolean[chicken.size()];

    }

    static void dfs(int k, int idx) {
        if(k == M){
            int sum = 0;
            for(int[] h :home){
                int min = Integer.MAX_VALUE;
                for(int c = 0; c < chicken.size(); c++){
                    if(selected[c]){
                        int dis = Math.abs(h[0]- chicken.get(c)[0]) + Math.abs(h[1]- chicken.get(c)[1]);
                        min = Math.min(dis,min);
                    }
                }
                sum += min;
            }
            ans = Math.min(sum,ans);


        } else {
            for(int cand = idx; cand < chicken.size(); cand++){
                if(selected[cand]) continue;
                selected[cand] = true;
                dfs(k+1,cand+1);
                selected[cand] = false;
            }

        }
    }
    public static void main(String[] args) {
        input();
        dfs(0, 0);
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
