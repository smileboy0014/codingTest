package com.example.algorithm.백준;

public class sol순위 {


    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}	));
    }

    public static int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];
        int answer = 0;

        for (int[] e : results) {
            graph[e[0]][e[1]] = 1; //이겼을 경우 1로 초기화
            graph[e[1]][e[0]] = - 1; // 졌을 경우 -1로 초기화
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    // i 가 j에게 이기는 경우
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    // i 가 j 에게 지는 경우
                    if(graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }

        for(int i = 0 ; i <=n; i++) {
            int count = 0;
            for (int j = 0; j <= n; j++) {
                if(graph[i][j] != 0) count++; // 이기거나 지거나 둘 중에 하나의 결과값을 아는 경우
            }
            if(count == n-1) answer++; // n인 사람이 n-1의 결과를 알고 있으면 자신의 순위도 알 수 있음!
        }
        return answer;
    }
}
