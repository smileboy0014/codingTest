package com.example.algorithm.Leetcode;

import java.util.Arrays;

public class sol1337 {

    public static void main(String[] args) {
        System.out.println(kWeakestRows(new int[][]
                {{1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}}, 2));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] arr = new int[m][2]; // [[row,cnt]..]

        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) cnt++;
            }
            arr[i][0] = i;
            arr[i][1] = cnt;
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i][0];
        }

        return ans;
    }
}
