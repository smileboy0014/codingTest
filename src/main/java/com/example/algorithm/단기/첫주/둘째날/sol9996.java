package com.example.algorithm.단기.첫주.둘째날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol9996 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        String patten = bf.readLine();
        String[] split = patten.split("\\*");
        String pattern1 = split[0];
        String pattern2 = split[1];

        for(int i = 0; i < n; i++){
            String word = bf.readLine();
            if(word.startsWith(pattern1) && word.endsWith(pattern2) && word.length() >= pattern1.length()+pattern2.length()){
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");;
            }
        }

        System.out.println(sb);
    }
}
