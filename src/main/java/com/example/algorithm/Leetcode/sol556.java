package com.example.algorithm.Leetcode;

public class sol556 {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(314));

        StringBuilder sb = new StringBuilder();

    }
    public static int nextGreaterElement(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int l = 0, r = sb.length(); // 문자열 비교 범위
        while (l < r) {
            // 맨 처음에만 더 커지기 위한 조건, 그 이후로는 더 작아지기 위한 조건
            // 더 커지거나 작아지기 위해 바꿔야 하는 숫자의 인덱스를 구함
            int[] change = (l == 0) ? findChangeToGreater(sb.substring(l, r)) : findChangeToSmaller(sb.substring(l, r));
            // 더 커지거나 작아질 수 없으면 종료
            if (change[0] == -1 || change[1] == -1) break;
            // 위에서 구한 결과에 맞춰 숫자를 바꾸기
            changeChar(sb, l + change[0], l + change[1]);
            // 바뀐 부분만 다시 검사하도록 범위 조정
            l += (change[0] + 1);
        }
        // 최종적으로 구한 결과가 정상적인 범위 안이면 답으로 반환, 아니면 -1 반환
        long nextNumber = Long.parseLong(sb.toString());
        return nextNumber <= Integer.MAX_VALUE && nextNumber > n ? (int) nextNumber : -1;
    }

    // 숫자로 구성된 문자열에서, 두 숫자를 바꿀 경우 전체 숫자가 커지는 부분을 구함
    private static int[] findChangeToGreater(String str) {
        int len = str.length();
        char[] charArr = str.toCharArray();
        int l = -1, r = -1;
        for (int s = 1; s < len; s++) {
            for (int d = 0; d < s; d++) {
                if (charArr[d] < charArr[s] && l <= d) {
                    l = d;
                    r = s;
                }
            }
        }
        return new int[]{l, r};
    }

    // 숫자로 구성된 문자열에서, 두 숫자를 바꿀 경우 전체 숫자가 작아지는 부분을 구함
    private static int[] findChangeToSmaller(String str) {
        int len = str.length();
        char[] charArr = str.toCharArray();
        int l = -1, r = -1;
        for (int s = 1; s < len; s++) {
            for (int d = s - 1; d >= 0; d--) {
                if (charArr[d] > charArr[s]) {
                    l = d;
                    r = s;
                }
            }
        }
        return new int[]{l, r};
    }

    // 문자열에서 b위치의 문자를 a위치로 이동
    private static String changeChar(StringBuilder sb, int a, int b) {
        return sb.insert(a, sb.charAt(b)).deleteCharAt(b + 1).toString();
    }
}
