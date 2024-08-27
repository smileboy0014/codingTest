package com.example.algorithm.Leetcode;

public class sol1641 {
    public static void main(String[] args) {
        System.out.println(countVowelStrings(4));
    }

    public static int countVowelStrings(int n) {
        int a,e,i,o,u;
        a=e=i=o=u=1;

        for(int k = 1; k< n; k++){
            a = a+e+i+o+u;
            //System.out.println("a="+a);
            e = e+i+o+u;
            //System.out.println("e="+e);
            i = i+o+u;
            //System.out.println("i="+i);
            o = o+u;
            //System.out.println("o="+o);
            u = u;
            //System.out.println("u="+u);
        }

        return a+e+i+o+u;
    }
}
