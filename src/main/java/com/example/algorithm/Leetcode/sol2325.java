package com.example.algorithm.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class sol2325 {

    public static void main(String[] args) {
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog","vkbs bs t suepuv"));
    }
    public static String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        String s = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = s.toCharArray();
        int idx = 0;
        for(char ch:key.toCharArray()){
            if(ch != ' '){
                Character value = map.putIfAbsent(ch,chars[idx]);
                if(value == null) idx++;
            }
        }
        StringBuilder sb = new StringBuilder();

        for(char ch:message.toCharArray()){

            if(ch == ' '){
                sb.append(" ");
            } else {
                sb.append(map.get(ch));
            }
        }

        return sb.toString();
    }
}
