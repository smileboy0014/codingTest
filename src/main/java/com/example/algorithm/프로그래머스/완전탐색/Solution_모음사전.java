package com.example.algorithm.프로그래머스.완전탐색;

public class Solution_모음사전 {

    static int Solution(String word) {
        String str = "AEIOU";
        int[] nums = {781, 156, 31, 6, 1};
        int result = word.length();
        int idx;

        for(int i = 0; i < word.length(); i++){
            idx = str.indexOf(word.charAt(i));
            result += nums[i]*idx;
        }
        return result;

    }


    public static void main(String[] args) {
        System.out.println(Solution("I"));
    }
}
