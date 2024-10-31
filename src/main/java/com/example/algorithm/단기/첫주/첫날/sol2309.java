package com.example.algorithm.단기.첫주.첫날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sol2309 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            sum += arr[i];
        }

        int rest = sum - 100;
        Arrays.sort(arr);

        int idx1 = 0;
        int idx2 = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (arr[i] + arr[j] == rest) {
                    idx1 = i;
                    idx2 = j;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < arr.length; i++) {
            if (i != idx2 && i != idx1) sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
