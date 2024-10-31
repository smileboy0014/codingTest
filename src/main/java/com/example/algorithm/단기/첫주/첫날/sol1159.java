package com.example.algorithm.단기.첫주.첫날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol1159 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] firsts = new int[26];

        for (int i = 0; i < n; i++) {
            char firstName = bf.readLine().charAt(0);
            firsts[firstName- 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 26; i++){
            if(firsts[i] >= 5){
                sb.append((char)( i + 'a'));
            }
        }

        if(sb.length() == 0){
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb);
        }

    }
}
