package com.example.algorithm.프로그래머스.level1;

import java.util.Stack;

public class Solution_stack1 {

    static String Solution(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '*') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }



        for(Object str :stack.toArray()){
            sb.append(str.toString());
        }

        return sb.toString();

    }


    public static void main(String[] args) {
        System.out.println(Solution("leet**cod*e"));
    }
}
