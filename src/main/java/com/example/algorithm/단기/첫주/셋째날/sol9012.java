package com.example.algorithm.단기.첫주.셋째날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class sol9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            String s = bf.readLine();
            stack.clear();
            for (char ch : s.toCharArray()) {
                if(stack.isEmpty()){
                    stack.add(ch);
                    continue;
                }
                if (stack.peek() == '(' && ch == ')') {
                    stack.pop();
                } else {
                    stack.add(ch);
                }
            }

            if (!stack.isEmpty()) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb);
    }
}
