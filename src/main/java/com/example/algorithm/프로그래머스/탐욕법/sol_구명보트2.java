package com.example.algorithm.프로그래머스.탐욕법;

import java.util.Arrays;

public class sol_구명보트2 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
    }


    public static int solution(int[] people, int limit) {
        int cnt = 0;
        int p1 = 0;
        int p2 = people.length - 1;
        Arrays.sort(people); // 오름차순 정렬

        while (p1 <= p2) {
            if (people[p1] + people[p2] <= limit) {
                p1++;
                p2--;
            } else {
                p2--;
            }

            cnt++;
        }


        return cnt;
    }

}
