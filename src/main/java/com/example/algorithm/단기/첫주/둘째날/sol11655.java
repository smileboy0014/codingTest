package com.example.algorithm.단기.첫주.둘째날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol11655 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringBuilder sb = new StringBuilder();
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s1.contains(String.valueOf(ch))) {
                int idx = s1.indexOf(String.valueOf(ch));
                sb.append(s1.charAt((idx+13)%26));
            } else if (s2.contains(String.valueOf(ch))) {
                int idx = s2.indexOf(String.valueOf(ch));
                sb.append(s2.charAt((idx+13)%26));
            } else {
                sb.append(ch);
            }
        }

        System.out.println(sb);
    }
}
