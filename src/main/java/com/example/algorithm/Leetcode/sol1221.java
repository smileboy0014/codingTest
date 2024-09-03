package com.example.algorithm.Leetcode;

import java.util.Stack;

public class sol1221 {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }

    public static int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || stack.peek() == ch) {
                stack.add(ch);

            } else {
                stack.pop();
            }
            if (stack.empty()) cnt++;

        }

        return cnt;
    }
}
