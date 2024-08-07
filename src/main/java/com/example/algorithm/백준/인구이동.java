package com.example.algorithm.백준;

import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class 인구이동 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, L, R, result;
    static int[][] matrix;

    static ArrayList<int[]> list;

    static boolean[][] visited;

    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static void input(){
        N = scan.nextInt();
        L = scan.nextInt();
        R = scan.nextInt();

        matrix = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] lines = scan.nextLine().split(" ");
           for(int j = 0; j < lines.length; j++){
               matrix[i][j] = Integer.parseInt(lines[j]);
           }
        }

        result = 0;
    }

    static void move(){

        while(true){
            boolean isMove = false;

            visited = new boolean[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        int sum = bfs(i,j);

                        if(list.size() > 1){
                            changePopulation(sum);
                            isMove = true;
                        }

                    }

                }
            }
            if(!isMove) break;
            result++;
        }
    }

    static void changePopulation(int sum){
        int avg =  sum/list.size();
        for (int[] ints : list) {
            int x = ints[0];
            int y = ints[1];
            matrix[x][y] = avg;
        }
    }


    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();
        int sum = matrix[x][y];

        q.add(new int[]{x,y});
        visited[x][y] = true;

        list.add(new int[]{x,y});

        while(!q.isEmpty()){

            int[] t = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = dir[d][0]+ t[0];
                int ny = dir[d][1]+ t[1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                int temp = Math.abs(matrix[t[0]][t[1]] - matrix[nx][ny]);
                if( L <= temp && temp <= R) {
                    visited[nx][ny] = true;
                    list.add(new int[]{nx, ny});
                    q.add(new int[]{nx,ny});
                    sum += matrix[nx][ny];
                }
            }

        }
        return sum;

    }

    public static void main(String[] args) {
        input();
        move();
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
