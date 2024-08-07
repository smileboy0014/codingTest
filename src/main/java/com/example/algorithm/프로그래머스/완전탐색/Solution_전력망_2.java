package com.example.algorithm.프로그래머스.완전탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_전력망_2 {

    static int answer = -1;

    static int cnt1 = 0;
    static int cnt2 = 0;

    static boolean cut = false;

    static int[][] nodes;

    static int bfs(int n, int start){
        int[] visited = new int[n + 1];
        int cnt = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int point = q.poll();
            visited[point] = 1;

            for(int i = 1; i <= n; i++){
                if(visited[i] == 1) continue;
                if(nodes[point][i] == 1){
                    q.add(i);
                    cnt++;

                }
            }
        }

        return (int) Math.abs(n - 2 * cnt);

    }

    static int solution(int n, int[][] wires) {
        int answer = n;
        nodes = new int[n+1][n+1];

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            nodes[a][b] = 1;
            nodes[b][a] = 1;
        }
        int a, b;
        for(int i=0; i<wires.length; i++){
            a= wires[i][0];
            b= wires[i][1];

            //선을 하나 끊고
            nodes[a][b]=0;
            nodes[b][a]=0;

            //bfs
            answer= Math.min(answer, bfs(n, a));

            //선 다시 복구
            nodes[a][b]=1;
            nodes[b][a]=1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }
}
