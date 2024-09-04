package com.example.algorithm.단기.첫주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class sol3986 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (Character ch : s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.add(ch);
                } else {
                    if (stack.peek() == ch) {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            }
            if(stack.isEmpty()){
                ans++;
            }
            stack.clear();
        }
        System.out.println(ans);
    }
}
