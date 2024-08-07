package com.example.algorithm.프로그래머스.힙;

import java.util.PriorityQueue;

public class sol_맵게 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        int minVal = Integer.MAX_VALUE;

        for (int s : scoville) {
            pq.add(s);
            minVal = Math.min(minVal, s);
        }

        if (minVal >= K) return -1;

        while (!pq.isEmpty()) {
            int firstS = pq.poll();
            if (!pq.isEmpty()) {
                int SecondS = pq.poll();

                int sum = firstS + SecondS * 2;
                ans++;
                pq.add(sum);

                if (!pq.isEmpty() && pq.peek() >= K) {
                    break;
                }
            }
        }
        return ans;
    }
}
