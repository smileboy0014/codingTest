package com.example.algorithm.단기.첫주.둘째날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol2559 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int n1 = Integer.parseInt(input[0]);
        int n2 = Integer.parseInt(input[1]);
        int[] arr = new int[n1+1];
        String[] input2 = bf.readLine().split(" ");
        for (int i = 1; i <= input2.length; i++) {
            arr[i] = Integer.parseInt(input2[i-1]); //[ 3 -2 -4 -9 0 3 7 13 8 -3 ]
            arr[i] += arr[i - 1];
        }
        int max = Integer.MIN_VALUE;
        for(int i = n2; i <= n1; i++){
            max = Math.max(max, arr[i] - arr[i-n2]);
        }


        System.out.println(max);
    }
}
