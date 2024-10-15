package com.example.algorithm.Leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class sol402 {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219",3));
    }

    public static String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < num.length()){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();

        while(sb.length()>1 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.toString();

    }
}
