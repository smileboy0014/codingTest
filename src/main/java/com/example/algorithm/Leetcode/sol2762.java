package com.example.algorithm.Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class sol2762 {
    public static void main(String[] args) {
        System.out.println(continuousSubarrays(new int[]{5, 4, 2, 4}));
    }

    public static long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0L;
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int start = 0;
        for (int end = 0; end < n; end++) {
            while (!max.isEmpty() && nums[max.peekLast()] < nums[end]) { //최댓값 유지를 위해
                max.pollLast();
            }
            max.offerLast(end);

            while (!min.isEmpty() && nums[min.peekLast()] > nums[end]) { //최솟값을 유지하기 위해
                min.pollLast();
            }
            min.offerLast(end);

            while (!max.isEmpty() && !min.isEmpty() && nums[max.peekFirst()] - nums[min.peekFirst()] > 2) {
                if (max.peekFirst() < min.peekFirst()) {
                    start = 1 + max.pollFirst();
                } else {
                    start = 1 + min.pollFirst();
                }
            }
            ans += end - start + 1;
        }
        return ans;
    }
}
