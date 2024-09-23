package com.example.algorithm.Leetcode;

public class sol1700 {
    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int[] counts = new int[2];
        for (int student : students) counts[student]++;

        int remaining = sandwiches.length;
        for (int sandwich : sandwiches) {
            if (counts[sandwich] == 0) break;
            if (remaining-- == 0) break;
            counts[sandwich]--;
        }

        return remaining;
    }
}
