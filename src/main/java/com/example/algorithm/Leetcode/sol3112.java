package com.example.algorithm.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class sol3112 {

    public static void main(String[] args) {
        System.out.println(minimumTime(3, new int[][]{{0, 1, 2}, {1, 2, 1}, {0, 2, 4}}, new int[]{1, 1, 5}));
    }

    public static class Node {
        int n;
        int w;

        public Node(int n, int w){
            this.n = n;
            this.w = w;
        }
    }

    public static int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<Node>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(new Node(e[1],e[2]));
            graph[e[1]].add(new Node(e[0],e[2]));
        }
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.w-b.w);
        pq.add(new Node(0, 0));

        boolean[] visit = new boolean[n];

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if(visit[curNode.n]) continue;
            visit[curNode.n] = true;

            for (Node connectNode : graph[curNode.n]) {
                int curTime = curNode.w + connectNode.w;
                if (curTime < result[connectNode.n] && curTime < disappear[connectNode.n]) {
                    result[connectNode.n] = curTime;
                    pq.add(new Node(connectNode.n, curTime));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (result[i] > disappear[i]) {
                result[i] = -1;
            }
        }

        return result;

    }
}
