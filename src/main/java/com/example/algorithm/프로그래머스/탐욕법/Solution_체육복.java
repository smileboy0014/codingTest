package com.example.algorithm.프로그래머스.탐욕법;

public class Solution_체육복 {

    static int Solution(int n, int[] lost, int[] reserve) {

        int answer = 0;
        int[] now = new int[31];

        for(int r:reserve){
            now[r] = 2;
            answer++;
        }

        for(int l:lost){
            int stu1 = l-1;
            int stu2 = l+1;
            if(now[stu1] >= 1){
                now[stu1] -=1;
                now[l] = 1;
                answer++;
            }
            if(now[l] != 1 && now[stu2] >= 1){
                now[stu2] -=1;
                now[l] = 1;
                answer++;
            }
        }



        return answer;
    }


    public static void main(String[] args) {
        System.out.println(Solution(5, new int[]{2, 4}, new int[]{3}));
    }
}
