package com.example.algorithm.단기.첫주.첫날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol10988 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        boolean isTrue = true;
        for(int i = 0;i < s.length()/2;i++){
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                isTrue = false;
                break;
            }
        }

        if (isTrue) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
