package com.example.algorithm.프로그래머스.level1;

public class Solution_공원산책 {
    static char[][] matrix;
    static int init_x, init_y;

    static public void move(String[] routes){

        for(String route:routes){
            String[] routeArr = route.split(" ");
            String dir = routeArr[0];
            int dis = Integer.parseInt(routeArr[1]);

            int nx = init_x;
            int ny = init_y;

            for(int i = 0; i < dis; i++){
                if(dir.equals("N")){
                    nx--;
                } else if(dir.equals("S")){
                    nx++;
                } else if(dir.equals("E")){
                    ny++;
                } else {
                    ny--;
                }

                if(nx >= 0 && ny >= 0 && nx < matrix.length &&  ny < matrix[0].length){
                    // 장애물 만났을 때
                    if(matrix[nx][ny] == 'X') break;
                    // 이동 가능할 때
                    if(i == dis-1){
                        init_x = nx;
                        init_y = ny;
                    }
                }

            }



        }

    }

    static public void init(String[] park, String[] routes){
        matrix = new char[park.length][park[0].length()];

        for(int i = 0; i < park.length; i++ ){
            for(int j = 0; j < park[i].length(); j++){
                if(park[i].charAt(j) == 'S') {
                    init_x = i;
                    init_y = j;
                }
                matrix[i][j] = park[i].charAt(j);
            }
        }

    }

    static int[] Solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        init(park, routes);
        move(routes);
        answer[0] = init_x;
        answer[1] = init_y;
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(Solution(new String[]{"SOO","OOO","OOO"},new String[]{"E 2","S 2","W 1"}));
    }
}
