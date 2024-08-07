package com.example.algorithm.백준;

import java.io.*;
import java.util.*;

public class 나무재태크 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, K, cnt;
    static int[][] matrix, foods;

    static boolean[][] visited;

    static PriorityQueue<Integer>[][] trees;

    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static LinkedList<Tree> deadList;


    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();

        matrix = new int[N+1][N+1];
        foods = new int[N+1][N+1];

        for (int[] ints : matrix) Arrays.fill(ints, 5);

        for(int i = 1; i <= N; i++){
            String[] lines = scan.nextLine().split(" ");
            for(int j = 1; j <= N; j++){
                foods[i][j] = Integer.parseInt(lines[j-1]);
            }
        }

        trees = new PriorityQueue[N+1][N+1];
        deadList = new LinkedList<>();

        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                trees[i][j] = new PriorityQueue<>();
            }
        }

        for(int i = 0; i < M; i++){
            String[] lines = scan.nextLine().split(" ");
            int x = Integer.parseInt(lines[0]);
            int y = Integer.parseInt(lines[1]);
            int age = Integer.parseInt(lines[2]);

            trees[x][y].add(age);

        }
    }

    static class Tree{
        int x, y, age;

        public Tree(int x, int y, int age){
            this.x = x;
            this.y = y;
            this.age = age;

        }
    }

    static void pro() {

        // 봄 0, 여름 1, 가을 2, 겨울 3, 4번을 보내야 하므로...
        for(int k = 0; k < K*4; k++){
            int season = k % 4;

            switch (season){
                case 0 : // 봄
                    for(int i = 1; i <= N; i++){
                        for(int j = 1; j <= N; j++){
                            if(!trees[i][j].isEmpty()) {

                                LinkedList<Integer> list = new LinkedList<>();

                                for(int q = 0; q < trees[i][j].size(); q++){
                                    Integer tree = trees[i][j].poll();

                                    // 양분을 먹고 나이 증가
                                    if(tree != null && (matrix[i][j] - tree) >= 0){
                                        matrix[i][j] -= tree;
                                        tree++;
                                        list.add(tree);
                                    }
                                    // 양분을 먹지 못해 죽은 나무들
                                    else {
                                        deadList.add(new Tree(i,j,tree));
                                    }
                                }
                                // 나이 먹은 나무 다시 queue 에 추가
                                for(Integer t: list){
                                    trees[i][j].add(t);
                                }
                            }
                        }
                    }
                    System.out.println("finish spring!");
                    break;
                case 1 : // 여름
                    for(Tree t: deadList){
                        int x = t.x;
                        int y = t.y;
                        int age = t.age;
                        int food = age/2;

                        matrix[x][y] += food;
                    }
                    System.out.println("finish summer!");
                    break;
                case 2 : // 가을
                    for(int i = 1; i <= N; i++){
                        for(int j = 1; j <= N; j++) {
                            LinkedList<Integer> list = new LinkedList<>();

                            if(trees[i][j].isEmpty()) continue;
                            PriorityQueue<Integer>[][] addTrees;
                            for(int t = 0; t < trees.length; t++){
                                Integer tree = trees[i][j].poll();

                                if(tree != null) list.add(tree);
                                if(tree != null && tree % 5 == 0){
                                    addTrees = bfs(i,j);
                                }
                            }

                            for(int n = 1; n <= N; n++){
                                for(int m = 1; m <= N; m++) {
                                }
                            }


                            // 번식한 나무 다시 추가하기
                            for(Integer t: list){
                                trees[i][j].add(t);
                            }
                        }
                    }
                    System.out.println("finish fall!");
                    break;
                case 3 : // 겨울
                    for(int i = 1; i <= N; i++){
                        for(int j = 1; j <= N; j++){

                            matrix[i][j] += foods[i][j];
                        }
                    }
                    deadList.clear();
                    System.out.println("finish winter!");
                    break;
            }

        }

        // 살아있는 나무 세기
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++) {
                if (!trees[i][j].isEmpty()){
                    while(!trees[i][j].isEmpty()){
                        trees[i][j].poll();
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);


    }

    static PriorityQueue<Integer>[][] bfs(int x , int y){
        PriorityQueue<Integer>[][] addTrees = new PriorityQueue[N+1][N+1];

        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                addTrees[i][j] = new PriorityQueue<>();
            }
        }

        visited = new boolean[N+1][N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        visited[x][y] = true;

        while(!q.isEmpty()){
            x = q.poll();
            y = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0], ny = y + dir[d][1];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if(visited[nx][ny]) continue;
                if(Math.abs(x-nx)+Math.abs(y-ny) <= 2){
                    visited[nx][ny] = true;

                    addTrees[nx][ny].add(1);
                    q.add(nx);
                    q.add(ny);
                }
            }
        }


    return addTrees;
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

