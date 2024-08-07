package com.example.algorithm.프로그래머스.스택;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class sol_기능개발 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = 1;
            int pro = progresses[i];
            int speed = speeds[i];
            while (pro + speed * day < 100) {
                day++;
            }
            System.out.println(day);
            q.add(day);
        }

        while (!q.isEmpty()) {
            int day = q.poll();
            int deploy = 1;


            while (!q.isEmpty() && q.peek() <= day) {
                q.poll();
                deploy++;
            }


            list.add(deploy);
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
