package com.example.algorithm.letetcode150;

import java.util.HashSet;
import java.util.Set;

public class sol36 {

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }


    public static boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rowSet = new HashSet[9];
        Set<Integer>[] colSet = new HashSet[9];
        Set<Integer>[][] boxSet = new HashSet[3][3];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i / 3][i % 3] = new HashSet<>();
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '0';

                    if (!rowSet[i].contains(n) && !colSet[j].contains(n) && !boxSet[i / 3][j / 3].contains(n)) {
                        rowSet[i].add(n);
                        colSet[j].add(n);
                        boxSet[i / 3][j / 3].add(n);
                    } else {
                        return false;
                    }
                }
            }
        }


        return true;
    }

//    HashSet<Integer>[] rowSets = new HashSet[9], colSets = new HashSet[9];
//    HashSet<Integer>[][] boxSets = new HashSet[3][3];
//
//        for (int i = 0; i < 9; i++) {//HashSet 초기화
//        rowSets[i] = new HashSet<>();
//        colSets[i] = new HashSet<>();
//        boxSets[i / 3][i % 3] = new HashSet<>();
//    }
//
//        for (int i = 0; i < 9; i++) {//이차원 board 배열 탐색
//        for (int j = 0; j < 9; j++) {
//            if (board[i][j]!='.') {
//                int num = board[i][j] - '0';
//
//                if (!rowSets[i].contains(num) && !colSets[j].contains(num) && !boxSets[i / 3][j / 3].contains(num)) {
//                    rowSets[i].add(num);
//                    colSets[j].add(num);
//                    boxSets[i / 3][j / 3].add(num);
//                } else {//중복이 발견된 경우
//                    return false;
//                }
//            }
//        }
}
