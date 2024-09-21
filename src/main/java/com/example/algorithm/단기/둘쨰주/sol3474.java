package com.example.algorithm.단기.둘쨰주;

import java.util.Scanner;

public class sol3474 {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int two = 0;
            int five = 0;

            for (int i = 2; i <= n; i *= 2) { // 2의 갯수 찾기
                two += n / i;
            }

            for (int i = 5; i <= n; i *= 5) { // 5의 갯수 찾기
                five += n / i;
            }
            sb.append(Math.min(two, five)).append("\n");
        }
        System.out.println(sb);
    }
}
