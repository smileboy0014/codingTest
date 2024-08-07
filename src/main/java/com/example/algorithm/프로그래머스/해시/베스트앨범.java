package com.example.algorithm.프로그래머스.해시;


import java.util.*;

public class 베스트앨범 {
    static LinkedList<Music> list;

    static class Music implements Comparable<Music> {

        int idx;
        String genre;
        int score;

        public Music(String genre, int score, int idx) {
            this.genre = genre;
            this.score = score;
            this.idx = idx;
        }

        @Override
        public int compareTo(Music o) {
            return o.score - this.score;
        }
    }

    public static void main(String[] args) {
        String[] genres = {"good","classic", "pop", "classic", "classic", "pop"};
        int[] plays = {200, 500, 600, 150, 800, 2500};

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }


        List<String> genre_order_list = new ArrayList<>(map.keySet());
        // 이렇게 하면 시간 초과가 난다.... why??
        Collections.sort(genre_order_list, (v1,v2) -> map.get(v2).compareTo(map.get(v2)));



        // 1.장르 선정
        List<String> genre_list = new ArrayList<>();
        while (map.size() != 0) {
            int max = -1;
            String max_key = "";
            for (String key : map.keySet()) {
                Integer score = map.get(key);
                if (score > max) {
                    max = score;
                    max_key = key;
                }
            }
            genre_list.add(max_key);
            map.remove(max_key);
        }

        ArrayList<Music> result = new ArrayList<>();
        for (String genre : genre_list) {
            ArrayList<Music> list = new ArrayList<>();
            for(int i = 0; i < genres.length; i++){
                if(genres[i].equals(genre)){
                    list.add(new Music(genre, plays[i], i));
                }
            }
            result.add(list.get(0));
            if(list.size() > 1){
                result.add(list.get(1));
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i).idx;
        }



        System.out.println("map = " + map);
    }
}
