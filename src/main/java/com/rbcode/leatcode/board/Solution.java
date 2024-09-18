package com.rbcode.leatcode.board;

public class Solution {

    public boolean check(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                if (!isValidRow(board, i) || !isValidColumn(board, j)) {
                    return false;
                }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int i) {
        int count = 0;
        for (int column = 0; column < board[i].length; column++) {
            if (board[i][column] == 'R') {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count != 0;
    }

    private boolean isValidColumn(char[][] board, int j) {
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            if (board[row][j] == 'R') {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count != 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().check(new char[][]{
                {'R', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'R', '.', '.', '.'},
                {'.', '.', 'R', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', '.'},
                {'.', 'R', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'R', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', 'R'},
                {'.', '.', '.', '.', '.', '.', 'R', '.'}}));
    }
}
