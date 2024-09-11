package com.example.algorithm.Leetcode;

import java.util.Arrays;

public class sol2037 {

    public static void main(String[] args) {
        System.out.println(minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4}));
    }


    public static int minMovesToSeat(int[] seats, int[] students) {
        int ans = 0;
        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i = 0; i < seats.length; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
}
