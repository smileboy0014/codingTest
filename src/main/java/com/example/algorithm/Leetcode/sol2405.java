package com.example.algorithm.Leetcode;

import java.util.Arrays;

public class sol2405 {

    public static void main(String[] args) {
        System.out.println(partitionString("sssssss"));
    }

    public static int partitionString(String s) {
        int[] chars = new int[26];
        int cnt = 1;
        for(char ch:s.toCharArray()){
            if(chars[ch-'a'] == 1){
                Arrays.fill(chars,0);
                cnt++;
            }
            chars[ch-'a']++;
        }
        return cnt;
    }
}
