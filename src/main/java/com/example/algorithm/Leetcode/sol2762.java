package com.example.algorithm.Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class sol2762 {
    public static void main(String[] args) {
        System.out.println(continuousSubarrays(new int[]{5,4,2,4}));
    }

    public static long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0L;
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int j=0;
        for(int i=0; i<n; i++) {
            while(!max.isEmpty() && nums[max.peekLast()]<nums[i]) {
                max.pollLast();
            }
            max.offerLast(i);
            while(!min.isEmpty() && nums[min.peekLast()]>nums[i]) {
                min.pollLast();
            }
            min.offerLast(i);

            while(!max.isEmpty() && !min.isEmpty() && nums[max.peekFirst()] - nums[min.peekFirst()] > 2) {
                if(max.peekFirst() < min.peekFirst())
                    j = 1+max.pollFirst();
                else
                    j = 1+min.pollFirst();
            }
            ans += i - j + 1;
        }
        return ans;
    }
}
