package com.example.algorithm.단기.첫주.셋째날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol1213 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int[] arr = new int[26];
        for (char ch : input.toCharArray()) {
            arr[ch - 'A']++;
        }
        int oddCnt = 0;
        char oddChar = ' '; // 홀수 문자
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {  //홀수이면
                oddCnt++;
                oddChar = (char) (i + 'A');
            }
            for (int j = 0; j < arr[i] / 2; j++) { //절반만큼 더해주기
                sb.append((char) (i + 'A'));
            }
        }

        if (oddCnt == 0) {
            StringBuilder newSb = new StringBuilder(sb);
            StringBuilder reverse = newSb.reverse();
            sb.append(reverse);
            System.out.println(sb);
        } else if (oddCnt == 1) {
            StringBuilder newSb = new StringBuilder(sb);
            sb.append(oddChar);
            StringBuilder reverse = newSb.reverse();
            sb.append(reverse);
            System.out.println(sb);
        } else {
            System.out.println("I'm Sorry Hansoo");
        }


        System.out.println();
    }
}

