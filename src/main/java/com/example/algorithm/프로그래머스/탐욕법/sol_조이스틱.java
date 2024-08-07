package com.example.algorithm.프로그래머스.탐욕법;

public class sol_조이스틱 {
    static int minLeft, minRight; // 역방향 최솟값, 순방향 최솟값
    public static void main(String[] args) {
//        System.out.println(solution("JEROEN"));
        System.out.println(solution("BAAAAABAA"));
    }

    public static int solution(String name) {

        int l = name.length();
        int idx = 0; // 다음 값 확인 사용
        int upDown = 0; //위아래 움직임
        int leftRight = name.length()-1; //초깃값을 최댓값으로 설정, 좌우 움직임

        // 위아래 움직이는 횟수와 좌우 움직이는 횟수 별도로 두고 풀기!
        for(int i = 0 ; i < l; i++){
            upDown += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            idx = i + 1;
            //연속되는 A 확인
            while(idx < l && name.charAt(idx) == 'A'){
                idx++;
            }
            //좌우 이동
            leftRight = Math.min(leftRight, i+(l-idx)+Math.min(i,l-idx));

        }

        return upDown+leftRight;

//        int idx = 0;
//
//        // 순방향
//        while(idx < name.length()){
//            char ch = name.charAt(idx);
//            int cnt = ch - 'A';
//            if(cnt != 0 && cnt > 13) cnt = 26-cnt;
//            minRight += cnt;
//            // 마지막에 이동을 안하므로
//            if(idx != name.length()-1) minRight++;
//            // 마지막이 A일 경우 빼주기
//            if(cnt == 0 && idx == name.length()-1) minRight--;
//            idx++;
//        }
//        System.out.println(minRight);
//
//        //역방향
//        idx = name.length()-1;
//        while(idx >= 0){
//            char ch = name.charAt(idx);
//            int cnt = ch - 'A';
//            if(cnt != 0 && cnt > 13) cnt = 26-cnt;
//            minLeft += cnt;
//            // 마지막에 이동을 안하므로
//            if(idx != 0) minLeft++;
//            // 마지막이 A일 경우 빼주기
//            if(cnt == 0 && idx == 1) minLeft--;
//            idx--;
//        }
//        minLeft--; // 처음 시작점이 마지막이니 -1 해주기
//        System.out.println(minLeft);
//
//        return Math.min(minLeft, minRight);

    }
}
