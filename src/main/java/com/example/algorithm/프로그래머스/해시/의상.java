package com.example.algorithm.프로그래머스.해시;

import java.util.*;

public class 의상 {

    public static void main(String[] args) {
        String[][] cloth = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int answer = 1;

        Map<String,Integer> map = new HashMap<>();

        for(String[] c:cloth){
            map.put(c[1], map.getOrDefault(c[1],0)+1);
        }


        for(String key:map.keySet()){
            answer *= map.get(key) + 1;
        }

        System.out.println(answer-1);


    }


}
