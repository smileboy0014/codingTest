package com.example.algorithm.프로그래머스.탐욕법;

public class Solution_큰수만들기 {

    static String Solution(String number, int k) {

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for(int i=0; i<number.length() - k; i++) {
            max = 0;
            for(int j = index; j<= k+i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(Solution("4177252841",4));
    }
}
