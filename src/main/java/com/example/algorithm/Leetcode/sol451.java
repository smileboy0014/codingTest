package com.example.algorithm.Leetcode;

import java.util.*;

public class sol451 {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static class Word implements Comparable<Word> {
        String word;
        int cnt;

        public Word(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            return o.cnt - this.cnt;
        }


    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        List<Word> words = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for(char ch:map.keySet()){
            int cnt = map.get(ch);
            words.add(new Word(String.valueOf(ch),cnt));
        }

        Collections.sort(words);

        for (Word word : words) {
            for (int j = 0; j < word.cnt; j++) {
                sb.append(word.word);
            }
        }
        return sb.toString();
    }
}
