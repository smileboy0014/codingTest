package com.example.algorithm.Leetcode;

public class CanReplace {

    static boolean Solution(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                if(leftEmpty && rightEmpty){
                    flowerbed[i] = 1;
                    n--;
                }
            }


        }
        return n > 0 ? false : true;
    }


    public static void main(String[] args) {
        System.out.println(Solution(new int[]{0,0,1,0,1},2));
    }
}
