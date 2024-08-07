package com.example.algorithm.프로그래머스.스택;

import java.util.*;

public class 프로세스 {


    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 4;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //우선순위 큐를 내림차순 정렬로 설정한다.
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) { //priorities의 값이 현재 오름차순 우선순위가 제일 높은 값과 같은지 확인한다.
                    if (i == location) {
                        answer++;
                        System.out.println("answer = " + answer);
                        return ;
//                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
//        return -1;

    }

}