package com.example.algorithm.프로그래머스.스택;

import java.util.Stack;

public class 올바른괄호 {

    public static void main(String[] args) {
        boolean answer = true;

        String s = "()()";

//        if (s.charAt(0) == ')') answer = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        if (!stack.empty()) answer = false;

        System.out.println("ss = " + answer);

        // 1. ) 시작 || ( 시작 -> ( 끝 : false
    }
}
