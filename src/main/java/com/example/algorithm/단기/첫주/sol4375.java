package com.example.algorithm.단기.첫주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class sol4375 {

    public static void main(String[] args) throws IOException {

        // 3 -> 3 ... 111 % 3 = 0 ???
        // 7 -> 6 ... 111111 % 7 = 0 ???
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            // 1번째 방식
            BigInteger n = new BigInteger(sc.next());
            BigInteger base = BigInteger.ZERO;
            while(true) {
                base = base.multiply(BigInteger.TEN).add(BigInteger.ONE);
                if (base.mod(n).equals(BigInteger.ZERO)) { //나머지가 0일 경우
                    System.out.println(base.toString().length());
                    break;
                }
            }
//            2번째 방식
//            int n = Integer.parseInt(sc.next());
//            int base = 1;
//            int cnt = 1;
//            while ((base=base%n) != 0) {
//                cnt++;
//                base = base*10+1;
//            }
//            System.out.println(cnt);
        }
    }
}
