package com.example.algorithm.프로그래머스.스택;

import java.util.Stack;

public class sol_올바른괄호 {

    public static void main(String[] args) {
        System.out.println(solution(")()("));
    }


    static boolean  solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch:s.toCharArray()){
            if(ch == '('){
                stack.add(ch);
            } else {
                if(stack.isEmpty()){
                    return false;
                } else {
                    stack.pop();
                }
//                if(!stack.isEmpty() && stack.peek() == '('){
//                    stack.pop();
//                }
            }
        }

        return stack.size() > 0 ? false : true;


    }

}
