package com.example.algorithm.Leetcode;

import java.util.Arrays;

public class sol869 {

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(32));
    }

    public static boolean reorderedPowerOf2(int n) {
        char[] origin = sortedDigits(n);
        for (int i = 0; i < 30; i++) {
            char[] newChars = sortedDigits(1 << i);
            if (Arrays.equals(origin, newChars)) {
                return true;
            }
        }
        return false;
    }

    private static char[] sortedDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);
        return chars;
    }



}
