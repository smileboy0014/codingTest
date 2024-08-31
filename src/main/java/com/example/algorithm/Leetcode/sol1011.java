package com.example.algorithm.Leetcode;

public class sol1011 {
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{3,2,2,4,1,4},3));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int maxCapacity = 0;
        int answer = 0;

        for(int w:weights){ // 최대 무게 계산
            maxCapacity += w;
        }

        int left = 0;
        int right = maxCapacity;

        while(left <= right){
            int mid = left + (right-left)/2;
            int spendDay = 0;
            int sum = 0;
            for(int i = 0; i < weights.length; i++){
                int temp = sum + weights[i];
                if(temp <= mid){
                    sum = temp;
                } else {
                    sum = weights[i];
                    spendDay++;
                }
            }

            if(spendDay <= days){
                answer = mid;
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
