package com.example.algorithm.프로그래머스.탐욕법;

public class Solution_조이스틱 {

    static int Solution(String name) {

        int answer = 0;

        int length = name.length();
        int conA; //A의 연속 갯수
        int move = name.length()-1; // 좌우 움직임 수

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            conA = i+1;
            while(conA < length && name.charAt(conA) == 'A') {
                System.out.println("good = " + i);
                conA++;
            }

            move = Math.min(move, i+(length-conA)+Math.min(i,length-conA));

        }






        return move+answer;



    }


    public static void main(String[] args) {
        System.out.println(Solution("BCDEFG"));
    }
}
