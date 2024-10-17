package com.example.algorithm.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class sol2195 {
    public static void main(String[] args) {
        System.out.println(minimalKSum(new int[]{96, 44, 99, 25, 61, 84, 88, 18, 19, 33, 60, 86, 52, 19, 32, 47, 35, 50, 94, 17, 29, 98, 22, 21, 72, 100, 40, 84}, 35));
    }

    public static long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        long sum = 0;

        for (int num : nums) {
            if (!set.contains(num) && num <= k) {
                k++;
                sum += num;
            }
            set.add(num);
        }

        long res = (long) (1 + k) * k / 2 - sum; //(1부터 k까지의 합) - 중복된 값들의 합
        return res;
    }
}
