package com.example.algorithm.프로그래머스.힙;

import java.util.*;

public class Solution_이중우선순위큐 {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minQ = new PriorityQueue<>();


        Map<Integer, Integer> map = new HashMap<>();

        for (String operation : operations) {
            String[] strArr = operation.split(" ");

            if (strArr[0].equals("I")) {
                maxQ.add(Integer.parseInt(strArr[1]));
                minQ.add(Integer.parseInt(strArr[1]));
            } else {
                if (strArr[1].equals("1")) {
                    Integer q = maxQ.poll();
//                    minQ.remove(q);
                } else {
                    Integer q = minQ.poll();
//                    maxQ.remove(q);
                }
            }
        }


        while(!minQ.isEmpty()){
            Integer q = minQ.poll();

            if(q != null){
                map.put(q, map.getOrDefault(q,0)+1);
            }


        }

        while(!maxQ.isEmpty()){

            Integer q = maxQ.poll();

            if(q != null){
                map.put(q, map.getOrDefault(q,0)+1);
            }
        }

        if(map.size() <= 1) return new int[]{0, 0};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer key : map.keySet()) {
            if(map.get(key) > 1){
                min = Math.min(min,key);
                max = Math.max(max,key);
            }

        }

        if(min != Integer.MAX_VALUE && max != Integer.MIN_VALUE){
            answer[0] = max;
            answer[1] = min;
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
    }
}
