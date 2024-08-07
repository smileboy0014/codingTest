package com.example.algorithm.경진대회1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class UDPC {

    static class Team implements Comparable<Team>{
        int score;
        String who;

        public Team(String who, int score){
            this.who = who;
            this.score = score;

        }


        @Override
        public int compareTo(Team o) {
          return o.score- this.score;

//          return who.compareTo(o.who);


        }
    }
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int U,D,P,C, U_C, D_P, UDP_cnt, DP_cnt, U_cnt;

    static String vote, result;

    static String[] team;

    static Team[] UDPC;
    static void input(){
        vote = scan.nextLine();
        team = new String[vote.length()];
        UDPC = new Team[3];

        for(int i = 0; i < vote.length(); i++){
            char newTeam = vote.charAt(i);
            team[i]= String.valueOf(newTeam);
        }
    }

    static void pro() {
        for(int i =0; i< vote.length(); i++){
            if(team[i].equals("U") || team[i].equals("C")){
                U_C++;
            } else if(team[i].equals("D") || team[i].equals("P")) {
                D_P++;
            }
        }

        if(U_C > ((D_P+1)/2)){
            sb.append("U");
        }

        if(D_P> 0){
            sb.append("DP");
        }




        System.out.println(sb);

    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
