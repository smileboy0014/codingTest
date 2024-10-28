package com.example.algorithm.Leetcode;

import java.util.Arrays;

public class sol1338 {

    public static void main(String[] args) {
        System.out.println(minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
    }

    public static int minSetSize(int[] arr) {

        int halfSize = arr.length/2;
        int totalSize = arr.length;
        int maxVal = 0;
        for(int n:arr){
            maxVal = Math.max(maxVal,n);
        }
        int[] nums = new int[maxVal+1];

        for(int n:arr){
            nums[n]++;
        }

        Arrays.sort(nums);

        int cnt = 0;

        for(int i = nums.length-1; i >= 0; i--){
            cnt++;
            totalSize -= nums[i];
            if(totalSize <= halfSize) break;
        }

        return cnt;


        // int halfSize = arr.length/2;
        // int totalSize = arr.length;
        // int maxVal = 0;
        // Map<Integer,Integer> map = new HashMap<>();

        // for(int n:arr){
        //     maxVal = Math.max(maxVal,n);
        //     map.put(n,map.getOrDefault(n,0)+1);
        // }
        // PriorityQueue<Map.Entry<Integer,Integer>> pq =
        // new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());

        // for(Map.Entry entry:map.entrySet()){
        //     pq.add(entry);
        // }
        // int cnt = 0;
        // while(!pq.isEmpty()){
        //     cnt++;
        //     totalSize -= pq.poll().getValue();
        //     if(totalSize <= halfSize) break;
        // }

        // return cnt;
    }
}
