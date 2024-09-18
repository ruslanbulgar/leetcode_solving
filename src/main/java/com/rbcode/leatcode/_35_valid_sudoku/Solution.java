package com.rbcode.leatcode._35_valid_sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private static final List<Character> CHARACTER_LIST = Arrays.asList('.', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public boolean isValidSudoku(char[][] board) {
        return  checkRows(board) &&
                checkColumns(board) &&
                checkSubBoards(board);
    }

    private boolean checkRows(char[][] board) {
        if (board.length != 9) {
            return false;
        }

        Set<Character> chars = new HashSet<>();
        for (char[] value : board) {
            if (value.length != 9) {
                return false;
            }
            chars.clear();
            for (char c : value) {
                if (!CHARACTER_LIST.contains(c)) {
                    return false;
                }
                if (c == '.') {
                    continue;
                }
                if (chars.contains(c)) {
                    return false;
                } else {
                    chars.add(c);
                }
            }
        }
        return true;
    }


    private boolean checkColumns(char[][] board) {
        Set<Character> chars = new HashSet<>();
        for (int j = 0; j < board[0].length; j++) {
            chars.clear();
            for (char[] value : board) {
                if (value[j] == '.') {
                    continue;
                }
                if (chars.contains(value[j])) {
                    return false;
                } else {
                    chars.add(value[j]);
                }
            }
        }
        return true;
    }


    private boolean checkSubBoards(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkSubBoard(board, i * 3, j * 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkSubBoard(char[][] board, int startRow,
                                        int startColumn) {
        Set<Character> chars = new HashSet<>();
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColumn; j < startColumn + 3; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                if (chars.contains(board[i][j])) {
                    return false;
                } else {
                    chars.add(board[i][j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

//        char[][] board = new char[][]{
//                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
//                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
//                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
//                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
//                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
//                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
//                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
//        };
        System.out.println("Valid: " + new Solution().isValidSudoku(board));
    }
}
