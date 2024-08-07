package com.example.algorithm.보라메;

import java.io.*;
import java.util.StringTokenizer;

public class 잠입 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, min_value, now_value;
    static int[][] matrix;

    static int move(int now_y, int[] line){



        return now_y;
    }

    static void input() {
        String result = "NO";
        min_value = N+M-2;
        now_value = 0;
        int[] now_position = new int[] {1,1};

        N = scan.nextInt();
        M = scan.nextInt();
        matrix = new int[N + 2][M + 1];

        for (int i = 1; i <= N; i++) {

            String[] lines = scan.nextLine().split(" ");
            if (lines[0].equals("0")){
                now_position[0] += 1;
                now_value++;
            }
            else if (lines[0].equals("1")) {
                int p = Integer.parseInt(lines[1]);
                if (lines[2].equals("L")) {
                    now_position[1] += p+1;
                    now_value+= p+1;
                } else {
                    if(now_position[1] < p){
                        now_position[0] += 1;
                        now_value++;
                    }
                    // !------x , 어차피 최적경로 x
                    else {
                        break;
                    }
                }

            } else {
                // R-R !---------x
                if(lines[2].equals("R") && lines[4].equals("R")){
                    if(Integer.parseInt(lines[1]) <= Integer.parseInt(lines[3])){
                        if(now_position[1] < Integer.parseInt(lines[1])){
                            now_position[0] += 1;
                            now_value++;
                        } else {
                            now_position[1] += Integer.parseInt(lines[1])+1;
                            now_value+= Integer.parseInt(lines[1])+1;
                        }
                        if(now_position[1] > M) break;
//                        for(int j = Integer.parseInt(lines[1]); j <=M; j++){
//                            matrix[i][j] = 1;
//                        }

                    } else {
                        if(now_position[1] < Integer.parseInt(lines[3])){
                            now_position[0] += 1;
                            now_value++;
                        } else {
                            now_position[1] += Integer.parseInt(lines[3])+1;
                            now_value+= Integer.parseInt(lines[3])+1;
                        }
                        if(now_position[1] > M) break;

                    }
                }
                // L-L x-----------!
                else if(lines[2].equals("L") && lines[4].equals("L")) {
                    if(Integer.parseInt(lines[1]) <= Integer.parseInt(lines[3])){
                        if(now_position[1] < Integer.parseInt(lines[3])){
                            now_position[1] += Integer.parseInt(lines[3])+1;
                            now_value+= Integer.parseInt(lines[3])+1;
                        } else {
                            now_position[0] += 1;
                            now_value++;
                        }
                    } else {
                        if(now_position[1] < Integer.parseInt(lines[1])){
                            now_position[1] += Integer.parseInt(lines[1])+1;
                            now_value+= Integer.parseInt(lines[1])+1;
                        } else {
                            now_position[0] += 1;
                            now_value++;
                        }
                    }

                    if(now_position[1] > M) break;

//                    if(Integer.parseInt(lines[1]) <= Integer.parseInt(lines[3])){
//                        for(int j = 1; j <=Integer.parseInt(lines[3]); j++){
//                            matrix[i][j] = 1;
//                        }


                }
                // L-R !------! || x----! !-----x
                else if(lines[2].equals("L") && lines[4].equals("R")) {
                    if(Integer.parseInt(lines[1]) > Integer.parseInt(lines[3])){
                        if(now_position[1] > Integer.parseInt(lines[1]) || now_position[1] < Integer.parseInt(lines[1])){
                            now_position[0] += 1;
                            now_value++;
                        } else {
                            now_position[1] += Integer.parseInt(lines[1])+1;
                            now_value+= Integer.parseInt(lines[1])+1;
                        }
                        if(now_position[1] > M) break;

//                        for(int j = Integer.parseInt(lines[3]); j <=Integer.parseInt(lines[1]); j++){
//                            matrix[i][j] = 1;
//                        }


                    } else {

                        if(Integer.parseInt(lines[1]) < now_position[1] && Integer.parseInt(lines[3]) > now_position[1]){
                            now_position[0] += 1;
                            now_value++;
                        } else {
                            if(now_position[1] < Integer.parseInt(lines[1])){
                                now_value = Integer.parseInt(lines[1])+1 - now_position[1];
                                now_position[1] = Integer.parseInt(lines[1])+1;

                            }
                        }


//                        for(int j = 1; j <=Integer.parseInt(lines[1]); j++){
//                            matrix[i][j] = 1;
//                        }
//                        for(int j = Integer.parseInt(lines[3]); j <=M; j++){
//                            matrix[i][j] = 1;
//                        }


                    }
                }
                // R-L  x----! !-----x || !------!
                else{
                    if(Integer.parseInt(lines[1]) > Integer.parseInt(lines[3])){
                        for(int j = Integer.parseInt(lines[1]); j <=M; j++){
                            matrix[i][j] = 1;
                        }

                        for(int j = 1; j <=Integer.parseInt(lines[3]); j++){
                            matrix[i][j] = 1;
                        }

                    } else {
                        for(int j = Integer.parseInt(lines[1]); j <=Integer.parseInt(lines[3]); j++){
                            matrix[i][j] = 1;
                        }
                    }

                }

            }
        }
    }

    static void pro() {
        String result = "NO";
        min_value = N+M-2;
        now_value = 0;
        int[] now_position = {1,1};

        for(int i = 1; i<= min_value; i++){
            if(now_value == min_value) break;


            now_value++;
        }

        System.out.println(result);
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
