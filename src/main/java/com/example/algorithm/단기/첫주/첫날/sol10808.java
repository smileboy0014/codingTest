package com.example.algorithm.단기.첫주.첫날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String word = bf.readLine();
        int[] arr = new int[26];

        for(char ch:word.toCharArray()){
            arr[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int n:arr){
            sb.append(n).append(" ");
        }

        System.out.println(sb);

    }
}
