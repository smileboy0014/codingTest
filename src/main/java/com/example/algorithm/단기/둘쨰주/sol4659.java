package com.example.algorithm.단기.둘쨰주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol4659 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input;
        char[] passwords;
        boolean flag;
        char prev;
        int count;

        while (!(input = bf.readLine()).equals("end")) {
            flag = false; // 초기화
            count = 0;
            prev = '.';
            passwords = input.toCharArray();

            for (char ch : passwords) {
                //1. a, e, i, o, u 포함하고 있는지
                if (isVowel(ch)) {
                    flag = true;
                }

                //2. aei, zxc 등 자움과 모음이 붙어서 3번이상 되면 안됨
                if (isVowel(ch) != isVowel(prev)) {
                    count = 1;
                } else {
                    count++;
                }

                //3. 연속 두번 문자 x, but ee , oo 는 허용
                if (count >= 3 || (ch == prev && (ch != 'e' && ch != 'o'))) {
                    flag = false;
                    break;
                }
                prev = ch;
            }

            if (flag) {
                System.out.println("<" + input + "> is acceptable.");
            } else {
                System.out.println("<" + input + "> is not acceptable.");
            }

        }
        bf.close();
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
