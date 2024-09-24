package com.example.algorithm.Leetcode;

import java.util.PriorityQueue;

public class sol1845 {

    class SeatManager {
        PriorityQueue<Integer> pq;
        int reserveIdx;

        public SeatManager(int n) {
            pq = new PriorityQueue<>();
            reserveIdx = 0;
            for (int i = 1; i <= n; i++) {
                pq.add(i); // 1, 2, 3, 4, 5
            }
        }

        public int reserve() {
            if (!pq.isEmpty()) {
                reserveIdx++;
                return pq.poll();
            }
            return 0;
        }

        public void unreserve(int seatNumber) {
            reserveIdx = seatNumber;
            pq.add(reserveIdx--);
        }
    }

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
}
