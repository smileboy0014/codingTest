package com.example.algorithm.프로그래머스.해시;

import java.util.*;

public class 전화번호_목록 {

    public static void main(String[] args) {

        boolean answer = true;
        String[] a = {"119", "97674223", "1195524421"};
        Arrays.sort(a);


        for(int i = 0; i < a.length-1; i++){
            String stand = a[i];
            if(a[i+1].startsWith(stand)){
                answer= false;
                break;
            }

        }

        System.out.println(answer);

    }
}
