package com.example.algorithm.프로그래머스.해시;

import java.util.Scanner;

public class baseForm {

    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int n, cap;

    static int[] deliveries = {1, 0, 3, 1, 2};
    static int[] pickups = {0, 3, 0, 4, 0};

    static void input(){
        n = 5;
        cap = 4;


    }

    static void pro() {
       String a = "A";

       if(a.toLowerCase().charAt(0) == 57){
           double d = Double.parseDouble(a);
           System.out.println("a = " + d);
       }
    }
    public static void main(String[] args) {
        input();
        pro();
    }


}
