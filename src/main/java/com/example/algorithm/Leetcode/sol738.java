package com.example.algorithm.Leetcode;

public class sol738 {

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(3332));
    }

    public static int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray(); // [3, 3, 2]
        int l = chars.length; // 3
        int startIdx = l; // 3

        for (int i = l - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                startIdx = i + 1;
                chars[i]--;
            }
        }

        for (int i = startIdx; i < l; i++) {
            chars[i] = '9';
        }

        return Integer.valueOf(String.valueOf(chars));
    }
}
