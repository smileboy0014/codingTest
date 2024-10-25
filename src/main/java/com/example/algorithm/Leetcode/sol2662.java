package com.example.algorithm.Leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class sol2662 {
    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{1, 1}, new int[]{4, 5}, new int[][]{{1, 2, 3, 3, 2}, {3, 4, 4, 5, 1}}));
    }

    public static int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        Set<Long> visit = new HashSet<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // [x,y,cost], cost가 적은 순으로
        pq.add(new int[]{start[0], start[1], 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], cost = cur[2];
            if (visit.contains((long) (1e5 + 1) * x + y)) continue;
            if (x == target[0] && y == target[1]) return cost;

            visit.add((long) (1e5 + 1) * x + y);

            pq.add(new int[]{target[0], target[1], cost + Math.abs(target[0] - x) + Math.abs(target[1] - y)});

            for (int[] special : specialRoads) {
                if (!visit.contains((long) (1e5 + 1) * special[2] + special[3])) {
                    pq.add(new int[]{special[2], special[3], Math.abs(x - special[0]) + Math.abs(y - special[1]) + cost + special[4]});
                }
            }

        }

        return -1;
    }
}
