package com.example.algorithm.단기.둘쨰주;

import java.util.Scanner;
import java.util.Stack;

public class sol2852 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int score1 = 0;
        int score2 = 0;

        int leadingTime1 = 0;
        int leadingTime2 = 0;

        int lastLeadingTime = 0;

        int endTime = 48 * 60;

        while (n-- > 0) {
            int score = scan.nextInt();
            String[] times = scan.next().split(":");
//            String score = split[0];
//            String[] times = split[0];
            int seconds = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);


            if (score1 > score2) { // 첫번째 팀이 이기고 있을 경우
                leadingTime1 += seconds - lastLeadingTime;
            } else if (score2 > score1) { //두번째 팀이 이기고 있을 경우
                leadingTime2 += seconds - lastLeadingTime;
            }

            // 점수 계산
            if (score == 1) {
                score1++;
            } else {
                score2++;
            }

            lastLeadingTime = seconds;

        }

        if(score1 > score2){
            leadingTime1 += endTime - lastLeadingTime;
        } else if(score2 > score1){
            leadingTime2 += endTime - lastLeadingTime;
        }
        int min1 = leadingTime1 / 60;
        int sec1 = leadingTime1 % 60;

        int min2 = leadingTime2 / 60;
        int sec2 = leadingTime2 % 60;

        System.out.printf("%02d:%02d\n", min1, sec1);
        System.out.printf("%02d:%02d\n", min2, sec2);
    }
}
