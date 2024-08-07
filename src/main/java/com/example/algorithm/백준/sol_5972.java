package com.example.algorithm.백준;

import java.io.*;
import java.util.*;

public class sol_5972 {

    static class Node{
        int to;
        int weight;

        public  Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

    }

    static FastReader scan = new FastReader();
    static int[] dist;
    static List<Node>[] nodes;


    public static void main(String[] args) {

        int n = scan.nextInt();
        int m = scan.nextInt();
        dist = new int[n + 1];
        nodes = new ArrayList[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] str = scan.nextLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);

            nodes[from].add(new Node(to, weight));
            nodes[to].add(new Node(from, weight));
        }

        bfs();

        System.out.println(dist[n]);
    }

    static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.weight)));
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : nodes[now.to]) {
                if (dist[now.to] + next.weight < dist[next.to]) {
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

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
