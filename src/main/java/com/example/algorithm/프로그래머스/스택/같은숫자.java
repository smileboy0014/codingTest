package com.example.algorithm.프로그래머스.스택;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 같은숫자 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        List<Integer> list = new ArrayList<>();

        int val = -1;
        for(int a:arr){
          if(val != a){
                list.add(a);
            }
            val = a;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        System.out.println("answer = " + answer);
    }
}
