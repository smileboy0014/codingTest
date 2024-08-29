package com.example.algorithm.프로그래머스.이분탐색;

import java.util.Arrays;

public class sol_입국심사 {

    public static void main(String[] args) {
        System.out.println(solution(6,new int[]{7,10}));
    }
    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = (long) n * times[times.length-1]; // 최대 오래 걸리는 경우

        while(left <= right){
            long mid = left + (right-left) /2;
            long complete = 0;
            for(int i = 0; i< times.length; i++){
                // 지금 계산한 시간으로 몇명이 통과될지 계산
                complete += mid/times[i];
            }

            if(complete < n){ // 그 시간 안에 전부 통과 못함
                left = mid + 1;

            } else {// 시간 안에 다 통과했지만, 더 최솟값이 있을 수도 있다.
                right = mid -1;
                answer = mid;
            }
        }

        return answer;
    }

}
