package com.example.algorithm.백준;

import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 낚시왕 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int R, C, M, sum, man_y;

    // 방향 : 0 : 위, 1 : 아래, 2 : 오른쪽, 3 : 왼쪽
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static int[][] A;

    static LinkedList<Shark>[][] S, S_copy;

    static Queue<Shark> Q;

    static class Shark {
        // (r,c) : 좌표, s : 속도, d : 방향, z : 크기
        // 방향 : 0 : 위, 1 : 아래, 2 : 오른쪽, 3 : 왼쪽
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;

        }
    }

    static void input() {
        R = scan.nextInt();
        C = scan.nextInt();
        M = scan.nextInt();

        S = new LinkedList[R + 1][C + 1];
        A = new int[R + 1][C + 1];

        for (int r = 0; r <= R; r++) {
            for (int c = 0; c <= C; c++) {
                S[r][c] = new LinkedList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            String[] lines = scan.nextLine().split(" ");

            int r = Integer.parseInt(lines[0]);
            int c = Integer.parseInt(lines[1]);
            int s = Integer.parseInt(lines[2]);
            int d = Integer.parseInt(lines[3]);
            int z = Integer.parseInt(lines[4]);

            A[r][c] = z;
            S[r][c].add(new Shark(r, c, s, d - 1, z));
        }
    }

    static void pro() {
        sum = 0;
        // 사람 위치 초기화
        man_y = 0;

        while (true) {
            man_y++;

            if (man_y > C) break;
            // 사람 이동
            move_man();
            // 상어 이동
            move_shark();
        }
        System.out.println(sum);
    }

    static void reset(){
        A = new int[R + 1][C + 1];
        S_copy = new LinkedList[R+1][C+1];

        for (int r = 0; r <= R; r++) {
            for (int c = 0; c <= C; c++) {
                S_copy[r][c] = new LinkedList<>();
            }
        }
    }

    static void move_man() {
        // 이동한 열에 상어 있는지 확인
        for (int r = 1; r <= R; r++) {
            // 만약 이동한 열에 상어가 있다면 get
            if (A[r][man_y] != 0) {
                // 잡은 크기 더해주기
                sum += A[r][man_y];
                A[r][man_y] = 0;
                S[r][man_y].poll();
                break;
            }
        }
    }

    static void move_shark() {

        reset();

        for (int r = 0; r <= R; r++) {
            for (int c = 0; c <= C; c++) {
                // 해당 위치에 상어가 없으면
                if (S[r][c].size() == 0) continue;
                // 상어의 속도가 0이면
                if (S[r][c].get(0).s == 0) {
                    S_copy[r][c].add(S[r][c].get(0));
                    S[r][c].clear();
                    break;
                };

                Shark s = S[r][c].get(0);
                // 상어 이동
                int x = s.r, y = s.c;
                for (int i = 0; i < s.s; i++) {
                    int nx = x + dir[s.d][0];
                    int ny = y + dir[s.d][1];
                    // 배열 밖으로 넘어가면 방향 전환
                    if (nx < 1 || ny < 1 || nx > R || ny > C) {
                        if (s.d == 0 || s.d == 1) {
                            nx -= dir[s.d][0]*2;
                            ny += dir[s.d][1];
                            if(s.d == 0){
                                s.d = 1;
                            } else {
                                s.d = 0;
                            }
                        } else {
                            nx += dir[s.d][0];
                            ny -= dir[s.d][1] * 2;
                            if(s.d == 2){
                                s.d = 3;
                            } else {
                                s.d = 2;
                            }
                        }
                    }
                    x = nx;
                    y = ny;
                }

                // 상어 이동한 위치에 배열
                s.r = x;
                s.c = y;
                S[r][c].clear();
                S_copy[x][y].add(s);
            }
        }

        // 상어 이동 후 동기화
        for (int r = 0; r <= R; r++) {
            for (int c = 0; c <= C; c++) {
                // 없는 경우 pass
                if (S_copy[r][c].size() == 0) continue;

                if (S_copy[r][c].size() > 1) {
                    int max_idx = 0;
                    for (int s = 0; s < S_copy[r][c].size() - 1; s++) {
                        if (S_copy[r][c].get(s).z < S_copy[r][c].get(s + 1).z) {
                            max_idx = s + 1;
                        }
                    }
                    Shark s = S_copy[r][c].get(max_idx);
                    S[r][c].add(s);
                    A[r][c] = s.z;
                }
                if (S_copy[r][c].size() == 1) {
                    S[r][c].add(S_copy[r][c].get(0));
                    A[r][c] = S_copy[r][c].get(0).z;
                }
            }
        }


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
