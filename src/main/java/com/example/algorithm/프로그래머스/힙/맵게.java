package com.example.algorithm.프로그래머스.힙;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 맵게 {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int s:scoville) pq.add(s);

        int min = pq.peek();

        while(K > min && pq.size() > 1){
            answer++;

            int firstQ = pq.poll();
            int secQ = pq.poll();

            int temp = firstQ + (secQ * 2);
            pq.add(temp);

            min = pq.peek();
        }

        if(K > min) answer = -1;

        System.out.println("answer = " + answer);




    }
}
