package com.example.algorithm.단기.첫주;

import java.io.*;
import java.util.StringTokenizer;

public class sol9996 {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        int n = scan.nextInt(); // 3
        String pattern = scan.next(); // a*d, aaaa*a, as*dd ...
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            boolean check = true;
            int idx =0;
            String inputFile = scan.next();

            // 만약 문자열의 길이가 패턴보다 작을 경우
            if (inputFile.length() < pattern.length()-1) { // Edge Case: *빼고 생각해야하는거 주의!!!!!!!
                sb.append("NE").append("\n");
                continue;
            }

            // 정방향 검사
            while (pattern.charAt(idx) != '*') {
                char char1 = pattern.charAt(idx);
                char char2 = inputFile.charAt(idx);
                if (char1 != char2) {
                    check = false;
                    break;
                }
                idx++;
            }

            if (!check) { // 중간 체크
                sb.append("NE").append("\n");
                continue;
            }

            // 역방향 검사
            idx = pattern.length() - 1;
            int fileIdx = inputFile.length() - 1;
            while (pattern.charAt(idx) != '*') {
                char char1 = pattern.charAt(idx);
                char char2 = inputFile.charAt(fileIdx);
                if (char1 != char2) {
                    check = false;
                    break;
                }

                idx--;
                fileIdx--;
            }

            // check 가 false 면 NE, true 면 DA
            if (!check) { // 중간 체크
                sb.append("NE").append("\n");

            } else {
                sb.append("DA").append("\n");
            }

        }

        System.out.println(sb);
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
