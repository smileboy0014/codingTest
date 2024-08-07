package com.example.algorithm.프로그래머스.스택;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발_good {

    static class Pro {
        int progress;
        int speed;

        public Pro(int pro, int sped) {
            this.progress = pro;
            this.speed = sped;
        }
    }

    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};


        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int takeTime = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

            if(!q.isEmpty() && q.peek() < takeTime){
                result.add(q.size());
                q.clear();
            }
            q.add(takeTime);

        }

        result.add(q.size());


        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);

        System.out.println("cnt = " + answer);
    }
}
