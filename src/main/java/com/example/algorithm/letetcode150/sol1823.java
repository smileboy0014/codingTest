package com.example.algorithm.letetcode150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class sol1823 {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5,2));
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            ans.add(i);
        }
        int cur=0;
        while(ans.size()>1){
            cur=(cur+k-1)%ans.size();
            ans.remove(cur);
        }
        return ans.get(0);
    }
}
