package com.example.algorithm.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sol1282 {

    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[] {3,3,3,3,3,1,3}));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0; i < groupSizes.length; i++){
            int size = groupSizes[i];
            map.putIfAbsent(size, new ArrayList<>());
            map.get(size).add(i);

            if(map.get(size).size() == size){
                ans.add(new ArrayList<>(map.get(size)));
                map.get(size).clear();
            }
        }

        return ans;
    }
}
