package com.example.algorithm.Leetcode;

import java.util.Stack;

public class sol2434 {

    public static void main(String[] args) {
        System.out.println(robotWithString("bdda"));
    }

    public static String robotWithString(String s) {
        // p, t 문자열을 관리할 변수
        StringBuilder p = new StringBuilder();
        Stack<Character> t = new Stack<>();

        // s의 각 위치에서 남은 문자들 중 가장 작은 문자를 계산하는 배열
        int n = s.length();
        char[] minSuffix = new char[n];

        minSuffix[n - 1] = s.charAt(n - 1);

        // minSuffix 배열을 채움
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = (char) Math.min(minSuffix[i + 1], s.charAt(i));
        }

        // s를 순회하면서 작업 수행
        int i = 0;
        while (i < n) {
            // s의 첫 번째 문자를 t에 추가
            t.push(s.charAt(i));
            i++;

            // t의 마지막 문자를 언제 p에 옮길지 결정
            while (!t.isEmpty() && (i == n || t.peek() <= minSuffix[i])) {
                p.append(t.pop());
            }
        }

        return p.toString();
    }
}
