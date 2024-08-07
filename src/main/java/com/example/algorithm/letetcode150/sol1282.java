package com.example.algorithm.letetcode150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sol1282 {

    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[]{3,3,3,3,3,1,3}));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int l = groupSizes.length;
        boolean[] isVisit = new boolean[l];
        // ans.add(new ArrayList<Ineger>()); // 이런식으로 답에 추가
        int idx = 1;
        for(int i = idx; i < l; i++){
            if(isVisit[i]) continue;

            int num = groupSizes[i];
            List<Integer> list = new ArrayList<>();
            list.add(i);
            isVisit[i] = true;
            while(idx < l && groupSizes[i-1] == groupSizes[i] && list.size() < num){
                idx++;
                list.add(idx);
                isVisit[idx] = true;
            }
            ans.add(list);
        }

        return ans;

    }


}
