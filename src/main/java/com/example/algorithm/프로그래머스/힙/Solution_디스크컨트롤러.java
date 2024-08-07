package com.example.algorithm.프로그래머스.힙;

import java.util.*;

public class Solution_디스크컨트롤러 {

    public static int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        int time = 0;
        int idx = 0;
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : map.keySet()) {

        }


        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        while (idx < len || !q.isEmpty()) {
            while (idx < len && jobs[idx][0] <= time)
                q.offer(jobs[idx++]);

            if (q.isEmpty())
                time = jobs[idx][0];
            else {
                int[] job = q.poll();
                answer += time - job[0] + job[1];
                time += job[1];
            }
        }

        return answer / len;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][] { {0, 3}, {1, 9}, {2, 6} }));
    }

}