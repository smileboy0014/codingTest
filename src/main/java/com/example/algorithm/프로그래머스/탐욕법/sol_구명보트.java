package com.example.algorithm.프로그래머스.탐욕법;

import java.util.Arrays;

public class sol_구명보트 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int l = people.length;
        boolean[] isBoat = new boolean[l];
        int p1 = 0;
        int p2 = l -1;
        while(p1 < l -1){
            p2 = l -1;
            while(isBoat[p1]){
                p1++;
            }

            while(p1 <= p2){

                int sum = people[p1] + people[p2];
                if(p1 == p2) sum = people[p1];
                if(sum <= limit){
                    answer++;
                    isBoat[p1] = true;
                    isBoat[p2] = true;
                    break;
                } else {
                    p2--;
                }
            }

            // isBoat[p1] = true;
        }

        return answer;
    }
}
