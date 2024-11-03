package com.example.algorithm.단기.첫주.둘째날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class sol1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]); // 포켓몬 수
        int m = Integer.parseInt(str[1]); // 문제 수

        String[] pk = new String[n + 1];
        Map<String,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pk[i + 1] = bf.readLine();
            map.put(pk[i+1],i+1);

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String s = bf.readLine();
            if (Character.isDigit(s.charAt(0))) {
                sb.append(pk[(Integer.parseInt(s))]).append("\n");
            } else {
                sb.append(map.get(s)).append("\n");;
            }
        }

        System.out.println(sb);
    }
}
