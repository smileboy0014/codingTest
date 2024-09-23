package com.example.algorithm.Leetcode;

import java.util.LinkedList;
import java.util.List;

public class sol1823 {

    public static void main(String[] args) {
        System.out.println(findTheWinner(5,2));
    }

    public static int findTheWinner(int n, int k) { // 5, 2
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i); // 1, 2, 3, 4, 5
        }

        int nowIdx = 0;
        int cnt = n - 1;

        while (cnt-- > 0) {
            int total = list.size();
            nowIdx += k - 1;

            while(nowIdx >= total) {
                nowIdx -= total;
            }
            list.remove(nowIdx);

        }
        return list.get(0);
    }
}
