package com.example.algorithm.단기.첫주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine(); //AABB , AAABB , AAAABBC, ABCD , AAABBBCC....
        // 1. 짝수일 때 AABB AABBCC, AB ... -> Good!!
        // 2. 홀수가 하나일 때 AABBC, AAABB ... -> Good!
        // 3. 홀수가 두개 이상 일 떄 ABCC, AAABBBCC ... Bad!!!
        StringBuilder sb = new StringBuilder();
        int[] chars = new int[26]; //ABCD...Z 26개!

        for (char ch : str.toCharArray()) {
            chars[ch - 'A']++; //각 문자의 갯수 새기
        }

        int oddCnt = 0; //홀수 갯수
        char oddChar = ' '; // 홀수 문자

        for (int i = 0; i < 26; i++) {
            if (chars[i] % 2 == 1) { //홀수일 경우
                oddCnt++;
                oddChar = ((char) (i + 'A'));
            }
            for (int j = 0; j < chars[i] / 2; j++) { //절반만큼 더해주기
                sb.append((char) (i + 'A'));
            }
        }

        if (oddCnt == 0) {
            StringBuilder newSb = new StringBuilder(sb);
            String reverse = newSb.reverse().toString();
            sb.append(reverse);
            System.out.println(sb);
        } else if (oddCnt == 1) {
            StringBuilder newSb = new StringBuilder(sb);
            sb.append(oddChar);
            String reverse = newSb.reverse().toString();
            sb.append(reverse);
            System.out.println(sb);
        } else {
            System.out.println("I'm Sorry Hansoo");
        }
    }
}
