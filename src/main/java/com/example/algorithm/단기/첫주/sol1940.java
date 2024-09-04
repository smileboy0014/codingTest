package com.example.algorithm.단기.첫주;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sol1940 {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        // 투포인터로 풀면 될듯??
        int n = scan.nextInt();
        int target = scan.nextInt();
        int ans = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        // 순차적으로 정렬
        Arrays.sort(arr);

        //순회하면서 포인터 옮기기
        int p1 = 0;
        int p2 = arr.length - 1;
        while (p1 < p2) {
            if(arr[p1] + arr[p2] > target){
                p2--;
            } else if(arr[p1] + arr[p2] < target){
                p1++;
            } else {
                p1++;
                p2--;
                ans++;
            }
        }

        System.out.println(ans);
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
