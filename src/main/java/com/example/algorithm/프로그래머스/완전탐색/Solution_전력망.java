package com.example.algorithm.프로그래머스.완전탐색;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_전력망 {

    static int answer;

    static int[][] nodes;
    static boolean[] checked;


    static void bfs(int n, int start) {
        checked = new boolean[n + 1];
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        checked[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 1; i <= n; i++) {
                if (checked[i]) continue;
                if (nodes[node][i] == 1) {
                    checked[i] = true;
                    cnt++;
                    q.add(i);
                }
            }

        }

        answer = Math.min(Math.abs(n - 2 * cnt), answer);


    }

    static int solution(int n, int[][] wires) {
        nodes = new int[n + 1][n + 1];
        answer = n;
        // node 관계식 초기화
        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];

            nodes[node1][node2] = 1;
            nodes[node2][node1] = 1;
        }
        // for문 돌면서 하나씩 끊어서 갯수 세보기
        for (int i = 0; i < wires.length; i++) {
            int node1 = wires[i][0];
            int node2 = wires[i][1];
            nodes[node1][node2] = 0;
            nodes[node2][node1] = 0;
            bfs(n, node1);
            nodes[node1][node2] = 1;
            nodes[node2][node1] = 1;
        }
        return answer;

    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }
}
