package com.example.algorithm.letetcode150;

import java.util.ArrayList;
import java.util.List;

public class sol1641 {
    static int ans;
    static StringBuilder sb;
    static List<String> result;

    public static void main(String[] args) {
        System.out.println(countVowelStrings(2));
    }

    public static int countVowelStrings(int n) {
        String[] strs = {"a", "e", "i", "o", "u"};
        sb = new StringBuilder();
        result = new ArrayList<>();

        dfs(n, 0, sb, strs);
        return ans;
    }

    private static void dfs(int n, int nowIdx, StringBuilder sb, String[] strs) {
        if (n == sb.length()) {
            ans++;
            result.add(sb.toString());
        } else {
            for (int i = nowIdx; i < strs.length; i++) {
                sb.append(strs[i]);
                dfs(n, i, sb, strs);
                sb.delete(sb.length() - 1, sb.length());
            }
        }

//        int start = selected[k-1];
//        if(start == 0 ) start = 1;
//        for(int cand = start; cand <=N; cand++){
//            selected[k] = cand;
//            rec_fun(k+1);
//            selected[k] = 0;
//        }

    }
}
