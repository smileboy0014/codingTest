package com.example.algorithm.Leetcode;

import java.util.*;

public class sol437 {

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3},2));
    }

    public static class Number implements Comparable<Number> {
        int num;
        int fre;

        public Number(int num,int fre){
            this.num = num;
            this.fre = fre;
        }

        @Override
        public int compareTo(Number o) {
            return o.fre - this.fre;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {

        // sol1. use heap
        int[] ans = new int[k];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue()
        );

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            heap.add(entry);
        }

        for(int i = 0; i < k; i++){
            ans[i] = heap.poll().getKey();
        }

        return ans;

        // sol2. use Custom Class
//        int[] ans = new int[k];
//        Map<Integer,Integer> map = new HashMap<>();
//
//        for(int i = 0 ; i < nums.length; i++){
//            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//        }
//
//        List<Number> numbers = new ArrayList<>();
//
//        for(int key:map.keySet()){
//            int val = map.get(key);
//            numbers.add(new Number(key,val));
//
//        }
//
//        Collections.sort(numbers);
//
//        for(int i = 0; i < k; i++){
//            ans[i] = numbers.get(i).num;
//        }
//        return ans;
    }
}
