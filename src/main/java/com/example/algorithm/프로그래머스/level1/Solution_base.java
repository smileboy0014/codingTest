package com.example.algorithm.프로그래머스.level1;

import java.util.*;

public class Solution_base {


    static String Solution(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        char[] charArr1 = word1.toCharArray();
        char[] charArr2 = word2.toCharArray();

        int l1 = charArr1.length;
        int l2 = charArr2.length;

        Queue<Character> que1 = new LinkedList<>();
        Queue<Character> que2 = new LinkedList<>();

        for(char ch:charArr1){
            que1.add(ch);
        }


        for(char ch:charArr2){
            que2.add(ch);
        }

        while(!que1.isEmpty() || !que2.isEmpty()){
            if(l1 > l2){
                if(!que1.isEmpty()){
                    char ch1 = que1.poll();
                    sb.append(Character.toString(ch1));
                }

                if(!que2.isEmpty()){
                    char ch2 = que2.poll();
                    sb.append(Character.toString(ch2));
                }

            } else {
                if(!que2.isEmpty()){
                    char ch2 = que2.poll();
                    sb.append(Character.toString(ch2));
                }
                if(!que1.isEmpty()){
                    char ch1 = que1.poll();
                    sb.append(Character.toString(ch1));
                }

            }
        }

        return sb.toString();


    }
    public static void main(String[] args) {
        System.out.println(Solution("abcd","pq"));
    }
}
