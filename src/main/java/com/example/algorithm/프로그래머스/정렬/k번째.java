package com.example.algorithm.프로그래머스.정렬;

import java.util.Arrays;

public class k번째 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 2, 6, 3, 7, 4},new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){

            int[] newArr = Arrays.copyOfRange(array, commands[i][0]-1,commands[i][1]);
            Arrays.sort(newArr);
            answer[i] =  newArr[commands[i][2]-1];


        }
        return answer;
    }
}
