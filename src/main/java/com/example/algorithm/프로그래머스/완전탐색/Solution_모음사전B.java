package com.example.algorithm.프로그래머스.완전탐색;

import java.util.ArrayList;
import java.util.List;

public class Solution_모음사전B {
    static int cnt;
    static String st;

    static int ans;

    static int Solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }

    static List<String> list = new ArrayList<>();

    static void dfs(String str, int len) {
        if (len > 5) return;
        list.add(str);
        for (int i = 0; i < 5; i++) {
            dfs(str + "AEIOU".charAt(i), len + 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(Solution("U"));
    }
}
