package com.example.algorithm.백준;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, shark_x, shark_y, min_dist, min_x, min_y, shark_size, result, eat_cnt;

    static final int max_int = 21, max_val = 401;
    static int[][] matrix, min_matrix;

    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};


    static void input() {
        N = scan.nextInt();
        matrix = new int[N][N];
        min_matrix = new int[N][N];

        for(int i =0; i < N; i++){
            String[] lines = scan.nextLine().split(" ");
            for(int j = 0; j < N; j++){
                matrix[i][j] = Integer.parseInt(lines[j]);
                if(matrix[i][j] == 9){
                    shark_x = i; shark_y = j;
                    matrix[i][j] = 0;
                }
            }
        }

        shark_size = 2;
        eat_cnt = 0;
    }

    static void pro() {


        while(true){
            reset_val();
            bfs(shark_x, shark_y);
            if(min_x != max_int && min_y != max_int){
                result += min_matrix[min_x][min_y];
                eat_cnt++;

                // 사이즈 업
                if(eat_cnt == shark_size){
                    shark_size++;
                    eat_cnt = 0;
                }

                matrix[min_x][min_y] = 0;

                shark_x = min_x;
                shark_y = min_y;

            } else {
                break;
            }

        }

        System.out.println(result);

    }

    static void bfs(int x, int y){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        min_matrix[x][y] = 0;

        while(!q.isEmpty()){
            x = q.poll();
            y = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = x+dir[i][0];
                int ny = y+dir[i][1];

                // 배열 범위를 안 벗어날 때
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                // 방문 하지 않았을 때
                if(min_matrix[nx][ny] != -1) continue;
                // 상어의 크기가 물고기 크기 보다 크거나 같을 때
                if(matrix[nx][ny] > shark_size) continue;
                min_matrix[nx][ny] = min_matrix[x][y]+1;

                // 먹을 수 있는 물고기 일 경우                
                if(matrix[nx][ny] != 0 && matrix[nx][ny] < shark_size){
                    // 현재 물고기 까지의 이동 시간이 더 짧은 경우 
                    if(min_dist > min_matrix[nx][ny]){
                        min_x = nx;
                        min_y = ny;
                        min_dist = min_matrix[nx][ny];
                    }
                    // 현재 물고기 까지의 이동 시간이 같으면
                    else if(min_dist == min_matrix[nx][ny]){
                        // 1) 가장 위쪽
                        if(min_x == nx){
                            if(min_y > ny){
                                min_x = nx;
                                min_y = ny;
                            }
                        }
                        // 가장 왼쪽
                        else if(min_x > nx){
                            min_x = nx;
                            min_y = ny;
                        }

                    }

                }

                q.add(nx);
                q.add(ny);

            }
        }

    }

    static void reset_val(){
        for(int i = 0; i < N; i++) Arrays.fill(min_matrix[i],-1);

        min_dist = max_val;
        min_x = max_int;
        min_y = max_int;
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