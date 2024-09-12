package com.example.algorithm.단기.둘쨰주;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class sol2870 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        List<BigInteger> list = new ArrayList<>();
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            String line = scan.next();
            String replace = line.replaceAll("[^0-9]", "-");
            String[] splitString = replace.split("-");

            for (String s : splitString) {
                if (!s.equals("")) {
                    list.add(new BigInteger(s));
                }
            }
        }
        Collections.sort(list);

        for (BigInteger num : list) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
