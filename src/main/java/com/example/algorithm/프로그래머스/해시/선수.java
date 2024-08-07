package com.example.algorithm.프로그래머스.해시;

import java.util.HashMap;
import java.util.Map;

public class 선수 {
    public static void main(String[] args) {
        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};

        String answer = "";

        Map<String,Integer> map = new HashMap<>();

        for(String p : participant){
            map.put(p,map.getOrDefault(p,0)+1);
        }

        for(String c: completion){
            if(map.get(c) == 1) map.remove(c);
        }

        for(String key : map.keySet()){
            answer = key;
        }


//        return answer;
    }



}
