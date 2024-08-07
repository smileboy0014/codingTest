package com.example.algorithm.프로그래머스.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class K번째수 {
    public static void main(String[] args) {
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
//        return answer;
    }


//        int[] answer = {};
//        answer = new int[commands.length];
//
//        for(int i =0; i<commands.length; i++) {
//            List<Integer> arrInt = new ArrayList<Integer>();
//            for(int j = commands[i][0]-1; j<commands[i][1]; j++) {
//                arrInt.add(array[j]);
//            }
//            Collections.sort(arrInt);
//            answer[i] =arrInt.get(commands[i][2]-1);
//        }
//        return answer;

    }

