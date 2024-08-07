package com.example.algorithm.프로그래머스.정렬;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        String nums[] = new String[numbers.length];
        for (int i=0; i<nums.length; i++) nums[i] = numbers[i] + "";

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        String answer = "";
        for(String s: nums) answer+=s;
        answer = answer.charAt(0) == '0' ? "0" : answer;
        System.out.println("answer = " + answer);

    }
}
