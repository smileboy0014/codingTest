package com.example.algorithm.프로그래머스.탐욕법;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_구명보트 {

    static int Solution(int[] people, int limit) {

        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();

        Arrays.sort(people);


        for (int person : people) {
            sum = 0;
            if (q.isEmpty()) {
                q.add(person);
                sum = person;
            } else {
                int weight = q.peek();
                sum = weight + person;
            }

            if (sum >= limit) {
                q.poll();
                answer++;
            } else {
                q.poll();
                q.add(sum);
            }

        }

        if(!q.isEmpty()) answer++;

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(Solution(new int[]{70, 50, 80, 50},100));
    }
}
