package com.example.algorithm.단기.첫주.둘째날;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class sol9375 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            Map<String, Integer> map = new HashMap<>(); //종류, 갯수
            for (int j = 0; j < n; j++) {
                String name = scan.next();
                String type = scan.next();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }


            int ans = 1;
            for (String key : map.keySet()) {
                Integer typeCnt = map.get(key);
                ans *= typeCnt + 1;

            }

            System.out.println(ans - 1);

        }


    }
}
