package com.example.algorithm.Leetcode;

import java.util.Arrays;

public class sol2280 {
    public static void main(String[] args) {
//        System.out.println(minimumLines(new int[][]{{36,9},{17,93},{34,4},{30,11},{11,41},{53,36},{5,92},
//                {81,92},{28,36},{3,45},{72,33},{64,1},{4,70},{16,73},{99,20},{49,33},{47,74},{83,91}}));

        System.out.println(minimumLines(new int[][]{{1,1},{500000000,499999999},{1000000000,999999998}}));
    }

    public static int minimumLines(int[][] stockPrices) {
        if(stockPrices.length == 1) return 0;
        if(stockPrices.length == 2) return 1;

        Arrays.sort(stockPrices,(o1, o2)->o1[0]-o2[0]);

        int ans = 1;
        double[] vals = new double[stockPrices.length-1];

        for(int i = 0; i < stockPrices.length-1; i++){
            vals[i] = (double)(stockPrices[i+1][1] - stockPrices[i][1])/(stockPrices[i+1][0] - stockPrices[i][0]);
        }

        for(int i = 0; i < vals.length-1; i++){
            if(vals[i] != vals[i+1]) ans++;
        }


        return ans;
    }
}
