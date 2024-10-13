package com.example.algorithm.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sol1286 {

    static class CombinationIterator {
        List<String> ans;
        int idx;
        public CombinationIterator(String characters, int combinationLength) {
            ans = new ArrayList<>();
            idx = 0;
            dfs(ans,new StringBuilder(),0,combinationLength, characters);
            Collections.sort(ans);
        }

        public void dfs(List<String> list, StringBuilder sb, int start, int len, String strs){
            if(sb.length() == len){
                String val = sb.toString();
                ans.add(val);
                return;
            }

            for(int i = start; i < strs.length(); i++){
                sb.append(strs.charAt(i));
                dfs(list,sb,i+1,len,strs);
                sb.setLength(sb.length()-1);
            }
        }

        public String next() {
            if(idx <= ans.size()){
                return ans.get(idx++);
            }
            return null;
        }

        public boolean hasNext() {
            if(idx == ans.size()){
                return false;
            }
            return true;
        }
    }

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
