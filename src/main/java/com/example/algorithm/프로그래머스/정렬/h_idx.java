package com.example.algorithm.프로그래머스.정렬;

import java.util.*;


public class h_idx {
    static class Node implements Comparable<Node> {
        int citation;
        int maxValue;

        public Node(int citation, int maxValue){
            this.citation = citation;
            this.maxValue = maxValue;
        }

        @Override
        public int compareTo(Node o) {
            return this.citation- o.citation;
        }
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        int answer = 0;

        int[] maxList = new int[citations.length];

        for(int i = 0; i < citations.length; i++){
            int num = citations[i];
            int max = 0;
            for (int citation : citations) {
                if (num <= citation) {
                    max++;
                }
            }
            maxList[i] = max;
        }

        List<Node> nodes = new ArrayList<>();

        for(int i = 0; i < citations.length; i++){
            nodes.add(new Node(citations[i], maxList[i]));
        }

        Collections.sort(nodes);

        for(int i = 0 ; i< nodes.size(); i++){
            Node n = nodes.get(i);
            if(n.citation > n.maxValue) {
                answer = nodes.get(i-1).maxValue;
                break;
            }
        }

        System.out.println("maxList = " + answer);

//        Arrays.sort(citations);
//        int max = 0;
//        for(int i = citations.length-1; i > -1; i--){
//            int min = (int)Math.min(citations[i], citations.length - i);
//            if(max < min) max = min;
//        }
//
//
//        System.out.println("maxList = " + max);
    }
}
