package com.example.algorithm.백준;

import java.io.*;
import java.util.*;

public class MoonTube {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, Q, cnt;

    static List<Node>[] nodes;
    static ArrayList<Question> questions;

    static boolean[] visited;
    static void input(){
        N = scan.nextInt();
        Q = scan.nextInt();

        nodes = new ArrayList[N+1];
        questions = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++){
            String[] lines = scan.nextLine().split(" ");
            int p = Integer.parseInt(lines[0]);
            int q = Integer.parseInt(lines[1]);
            int r = Integer.parseInt(lines[2]);

            nodes[p].add(new Node(q,r));
            nodes[q].add(new Node(p,r));
        }

        for(int j = 0; j < Q; j++) {
            String[] lines = scan.nextLine().split(" ");
            questions.add(new Question(Integer.parseInt(lines[0]), Integer.parseInt(lines[1])));

        }

    }

    static class Node{
        int n, r;

        public Node(int n, int r){
            this.n = n;
            this.r = r;

        }

    }

    static class Question{
        int k, v;

        public Question(int k, int v){
            this.k = k;
            this.v = v;

        }
    }

    static void bfs(Question q) {
        int k = q.k;
        int v = q.v;
        cnt = 0;

        visited = new boolean[N+1];
        Queue<Integer> que = new LinkedList<>();
        visited[v] = true;
        que.add(v);

        while(!que.isEmpty()){
            int curr = que.poll();

            for(Node n: nodes[curr]){
                if(!visited[n.n] && n.r >= k){
                    visited[n.n] = true;
                    que.add(n.n);
                    cnt++;
                }

            }
        }
        sb.append(cnt).append("\n");
    }


    public static void main(String[] args) {
        input();
        for(int q = 0; q < Q; q++) bfs(questions.get(q));
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
