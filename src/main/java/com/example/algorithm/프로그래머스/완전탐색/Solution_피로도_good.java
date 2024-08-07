package com.example.algorithm.프로그래머스.완전탐색;

public class Solution_피로도_good {
    static boolean[] checked;

    static int ans = 0;


    static int Solution(int k, int[][] dungeons){

        int l = dungeons.length;
        checked = new boolean[l];
        dfs(k, dungeons, 0);


        return ans;
    }

    static void dfs(int tired, int[][] dungeons, int cnt){
     for(int i = 0; i < dungeons.length; i++){
         if(!checked[i] && dungeons[i][0] <= tired){
             checked[i] = true;
             dfs(tired -= dungeons[i][1], dungeons, cnt+1);
             checked[i] = false;
         }
     }
        ans = Math.max(ans, cnt);
    }



    public static void main(String[] args) {
        System.out.println(Solution(80, new int[][] {{80,20},{50,40},{30,10}}));
    }
}
