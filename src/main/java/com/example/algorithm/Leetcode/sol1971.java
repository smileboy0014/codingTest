package com.example.algorithm.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class sol1971 {
    public static void main(String[] args) {
        System.out.println(validPath(3,new int[][]{{0,1},{1,2},{2,0}},0,2));
//        System.out.println(validPath(6,new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}},0,5));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n+1];
        boolean[] visit = new boolean[n+1];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        return dfs(graph,visit,source,destination);

    }

    public static boolean dfs(List<Integer>[] graph, boolean[] visit, int now, int destination){
        if(visit[now]) return false;
        if(now == destination) return true;
        visit[now] = true;

        for(int g:graph[now]){
            if(dfs(graph,visit,g,destination)) return true;
        }

        return false;
    }
}
