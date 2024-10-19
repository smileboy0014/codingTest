package com.example.algorithm.Leetcode;

public class sol2145 {
    public static void main(String[] args) {
        System.out.println(numberOfArrays(new int[]{1, -3, 4}, 1, 6));
    }

    public static int numberOfArrays(int[] differences, int lower, int upper) {

        int l = differences.length;
        long min = differences[0], max = differences[0], sum = 0;

        for (int i = 0; i < l; i++) {
            sum += differences[i];
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        long start = lower - min;
        long end = upper - max;

        return end - start >= 0 ? (int) (end - start) + 1 : 0;

//        long low = min < 0 ? lower - min : lower;
//
//        long high = max > 0 ? upper-max : upper;
//
//        if(high < low) return 0;
//
//
//        return (int)(high - low)+1;
    }
}
