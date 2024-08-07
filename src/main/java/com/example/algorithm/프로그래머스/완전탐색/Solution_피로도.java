package com.example.algorithm.프로그래머스.완전탐색;

public class Solution_피로도 {
    static int[] idxList;
    static boolean[] checked;
    static int maxVal = 0;


    static int Solution(int k, int[][] dungeons){

        int l = dungeons.length;
        idxList = new int[l+1];
        checked = new boolean[l+1];
        dfs(1, l, k, dungeons);


        return maxVal > 0 ? maxVal: -1;
    }

    static void dfs(int n, int l, int k,int[][] dungeons){
        if(n == l+1){
            explore(k,dungeons);
        } else {
            for(int cand = 1; cand <= l; cand++){
                if(!checked[cand]){
                    checked[cand] = true;
                    idxList[n] = cand;
                    dfs(n+1, l, k, dungeons);
                    checked[cand] = false;
                }
            }
        }
    }

    static void explore(int k, int[][] dungeons){
        int temp = k;
        int val = 0;
//        System.out.println("idxList[0]+idxList[1]+idxList[2] = " + idxList[1] + idxList[2]+idxList[3]);

        for(int i = 1; i <= dungeons.length; i++){

            if(dungeons[idxList[i]-1][0] <= temp){
                temp -= dungeons[idxList[i]-1][1];
                val++;
            }
        }

//        for(int i:idxList){
//
//            if(dungeons[i][0] <= temp){
//                temp -= dungeons[i][1];
//                val++;
//            }
//        }

        maxVal = Math.max(val, maxVal);

    }



    public static void main(String[] args) {
        System.out.println(Solution(80, new int[][] {{80,20},{50,40},{30,10}}));
    }
}
