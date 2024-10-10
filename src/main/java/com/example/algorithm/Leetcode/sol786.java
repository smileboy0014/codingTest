package com.example.algorithm.Leetcode;

public class sol786 {
    public static void main(String[] args) {
        System.out.println(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3));
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double l = 0;
        double r = 1;
        while (l < r) {
            double mid = (l + r) / 2;
            int[] smallerF = getSmallerFraction(arr, mid);
            int cnt = smallerF[0];

            if (cnt == k) {
                return new int[]{smallerF[1], smallerF[2]};
            } else if (cnt < k) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return null;
    }


    public static int[] getSmallerFraction(int[] arr, double num) {
        int cnt = 0;
        int maxC = 0, maxP = 1;

        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int hereC = arr[i];

            while (j < arr.length && hereC >= num * arr[j]) {
                j++;
            }

            if (j == arr.length) break;

            cnt += (arr.length - j);

            int hereP = arr[j];

            if (hereC*maxP > maxC*hereP) {
                maxC = hereC;
                maxP = hereP;
            }
        }

        return new int[]{cnt, maxC, maxP};
    }
}

