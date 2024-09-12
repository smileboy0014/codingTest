package com.example.algorithm.단기.둘쨰주;

import java.util.*;

public class sol2910 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        //n, maxNum, 1,1,3,3,5,5....
        int n = scan.nextInt();
        int maxNum = scan.nextInt();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); // (num,cnt)

        for (int i = 0; i < n; i++) {
            int num = scan.nextInt();
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Stack<Integer> stack = new Stack<>();

        for (int num : list) {
            if (!stack.contains(num)) {
                stack.add(num); // 순서 찾기
            }
        }

        // 빈도수를 기준으로 리스트를 정렬
        list.sort((o1, o2) -> {
            if (map.get(o1) == map.get(o2)) { // 빈도수가 같을 경우, 원래 입력 순서를 유지하도록 한다.
                return stack.indexOf(o1) - stack.indexOf(o2);
            } else { // 빈도수가 다른 경우, 빈도수를 기준으로 내림차순 정렬
                return Integer.compare(map.get(o2), map.get(o1));
            }
        });

        // 정렬된 리스트를 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i) + " ");
        }


        System.out.println(sb);
    }
}
