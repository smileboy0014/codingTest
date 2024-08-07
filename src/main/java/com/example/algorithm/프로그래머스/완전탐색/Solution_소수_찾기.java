package com.example.algorithm.프로그래머스.완전탐색;

import java.util.ArrayList;
import java.util.List;

public class Solution_소수_찾기 {

    static List<Integer> list = new ArrayList<>();
    static boolean[] check = new boolean[7];

    static int solution(String numbers) {

        int answer = 0;

        for (int i = 0; i < numbers.length(); i++) {
            dfs(numbers, "", i + 1);
        }

        for (int i = 0; i < list.size(); i++) {
            if (isPrime(list.get(i))) answer++;
        }

        return answer;
    }

    static void dfs(String str, String temp, int l) {
        if (temp.length() == l) {
            int num = Integer.parseInt(temp);
            if (!list.contains(num)) list.add(num);
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (!check[i]) {
                    check[i] = true;
                    temp += str.charAt(i);
                    dfs(str, temp, l);
                    check[i] = false;
                    temp = temp.substring(0, temp.length() - 1);
                }
            }
        }

    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;

    }


    public static void main(String[] args) {
        System.out.println(solution("175"));
    }
}
