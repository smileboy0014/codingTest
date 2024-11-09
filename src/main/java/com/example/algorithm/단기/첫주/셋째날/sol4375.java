package com.example.algorithm.단기.첫주.셋째날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class sol4375 {

    public static void main(String[] args) throws IOException {

        // 3 -> 3 ... 111 % 3 = 0 ???
        // 7 -> 6 ... 111111 % 7 = 0 ???
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = Integer.parseInt(sc.next());
            int base = 1;
            int cnt = 1;
            while ((base = base % n) != 0) {
                cnt++;
                base = base * 10 + 1;
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
