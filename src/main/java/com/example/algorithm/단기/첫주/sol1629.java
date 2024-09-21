package com.example.algorithm.단기.첫주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String[] strArr = str.split(" ");
        int num1 = Integer.parseInt(strArr[0]); //A
        int num2 = Integer.parseInt(strArr[1]); //B
        int num3 = Integer.parseInt(strArr[2]); //C

        // 결국 구하려는건 (A^B)%C
        // (10^11)%12
        // (10^11)%12 = (10^5 * 10^6)%12 = (10^5%12) * (10^6%12) ...


        System.out.println();
    }
}
