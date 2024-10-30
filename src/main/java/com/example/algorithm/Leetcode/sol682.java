package com.example.algorithm.Leetcode;

import java.util.Stack;

public class sol682 {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }

    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String o : operations) {
            if (o.equals("C")) {
                stack.pop();
            } else if (o.equals("D")) {
                stack.add(stack.peek() * 2);
            } else if (o.equals("+")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int sum = num1 + num2;
                stack.add(num1);
                stack.add(num2);
                stack.add(sum);
            } else {
                stack.add(Integer.valueOf(o));
            }
        }
        int sum = 0;

        for (int n : stack) {
            sum += n;
        }
        return sum;
    }
}
