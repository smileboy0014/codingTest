package com.example.algorithm.프로그래머스.스택;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class sol_개능개발 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{90, 90}, new int[]{10, 9}));
    }

    public static class Task{
        int pro;
        int speed;

        public Task(int pro,int speed){
            this.pro = pro;
            this.speed = speed;
        }
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Queue<Task> q = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            q.add(new Task(progresses[i], speeds[i]));
        }

        while(!q.isEmpty()){
            Task task = q.poll();
            int cnt = 1;
            int day = (100-task.pro)/task.speed;

            if(day != 1){
                while(true){
                    if(q.peek() == null) break;
                    Task temp = q.peek();
                    if(day >=(100-temp.pro)/temp.speed){
                        q.poll();
                        cnt++;
                    } else {
                        break;
                    }
                }
            }

            list.add(cnt);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
