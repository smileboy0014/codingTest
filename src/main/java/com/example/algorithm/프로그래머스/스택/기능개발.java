package com.example.algorithm.프로그래머스.스택;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {

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


        Queue<Pro> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add(new Pro(progresses[i], speeds[i]));
        }


        while (!queue.isEmpty()) {
            Pro val = queue.poll();
            int takeTime = (int) Math.ceil((100.0 - val.progress) / val.speed);
            list.add(takeTime);
        }

        int pass = 1;
        int pre = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            int now = list.get(i);

            if (now > pre) {
                result.add(pass);
                pass = 1;
                pre = now;
            } else {
                pass++;
            }

            if (i == list.size() - 1) {
                result.add(pass);
                break;
            }

        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);

        System.out.println("cnt = " + answer);
    }
}
