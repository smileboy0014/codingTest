package com.example.algorithm.Leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class sol1529 {

    public static void main(String[] args) {
        System.out.println(minFlips("10111"));
    }

    public static int minFlips(String target) {
        char[] chars = new char[target.length()];
        Arrays.fill(chars, '0');
        int ans = 0;
        for(int i = 0; i < target.length(); i++){
            if(target.charAt(i) != chars[i]){
                int idx = i;
                while(idx < target.length()){
                    chars[idx++] = target.charAt(i);
                }
                ans++;
            }
        }

        return ans;

    }

}
