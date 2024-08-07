package com.example.algorithm.프로그래머스.스택;

import java.util.LinkedList;
import java.util.Queue;

public class 다리_트럭 {
    public static void main(String[] args) {
        int[] truck_weights = {7, 4, 5, 6};
        int weight = 10;
        int bridge_length = 2;

        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        int sum = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while(true){
                // 큐에 아무 트럭도 없을 경우
                if(q.isEmpty()){
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                } else if(q.size() == bridge_length){ //큐에 다리 길이만큼 트럭이 가득 찬 경우
                    sum -= q.poll();
                } else { //다리 길이 만큼 큐가 덜 찬 경우
                    if(sum + truck <= weight){
                        q.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        q.add(0);
                        time++;
                    }

                }
            }
        }

//        return time + bridge_length;



    }
}
