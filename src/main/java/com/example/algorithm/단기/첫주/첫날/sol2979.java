package com.example.algorithm.단기.첫주.첫날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol2979 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] prices = new int[3];
        String s = bf.readLine();
        String[] sArr = s.split(" ");
        int[] track = new int[101];

        for (int i = 0; i < sArr.length; i++) {
            prices[i] = Integer.parseInt(sArr[i]); // [5, 3, 1]
        }

        for (int i = 0; i < 3; i++) {
            String[] strs = bf.readLine().split(" ");
            int in = Integer.parseInt(strs[0]);
            int out = Integer.parseInt(strs[1]);
            for (int j = in; j < out; j++) {
                track[j]++;
            }
        }
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if (track[i] == 1) {
                sum += prices[0];
            } else if (track[i] == 2) {
                sum += prices[1] * 2;
            } else if (track[i] == 3) {
                sum += prices[2] * 3;
            }
        }

        System.out.println(sum);

    }
}
