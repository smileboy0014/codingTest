package com.example.algorithm.단기.둘쨰주;

import java.util.Scanner;

public class sol2828 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        int n = scan.nextInt();
        int l = scan.nextInt();
        int appleCnt = scan.nextInt();
        int[] position = new int[appleCnt];
        int ans = 0;

        for (int i = 0; i < appleCnt; i++) {
            int p = scan.nextInt();
            position[i] = p;
        }
        int p1 = 1; // 막대 시작 포인트
        int p2 = l; // 막대 끝 포인트

        // 사과가 다 떨어질 때까지
        for (int i = 0; i < appleCnt; i++) {
            int point = position[i]; // 사과 떨어지는 위치
            if (point < p1) { // 포인트가 p1 보다 왼쪽에 있으면
                int move = p1 - point;
                ans += move;
                p1 = point;
                p2 -= move;
            } else if(p2 < point){ // 포인트가 p2보다 오른쪽에 있으면
                int move = point - p2;
                ans += move;
                p1 += move;
                p2 = point;
                if(p1 > p2) p1 = p2;
            }

        }

        System.out.println(ans);

    }
}
