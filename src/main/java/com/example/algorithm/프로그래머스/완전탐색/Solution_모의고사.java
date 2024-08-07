package com.example.algorithm.프로그래머스.완전탐색;

public class Solution_모의고사 {

    static int[] Solution(int[] answers){
        int[] answer = new int[3];

        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        int val1 = 0;
        int val2 = 0;
        int val3 = 0;
        int[][] nums = new int[][]{{0,0},{0,0},{0,0}};

        for(int i = 0; i < answers.length; i++){
             val1 = p1[i % 5];
             val2 = p2[i % 8];
             val3 = p3[i % 10];

            if(val1 == answers[i]) count1++;
            if(val2 == answers[i]) count2++;
            if(val3 == answers[i]) count3++;

        }
        if(count1 == count2 && count2 == count3) return new int[]{1,2,3};
        for(int i = 0; i < 3; i++){
            Math.max(count1, count2);
        }
        return answer;

    }

    public static void main(String[] args) {
        System.out.println(Solution(new int[]{1,3,2,4,2}));
    }
}
