package com.rbcode.leatcode._36_solve_sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    private static final Set<Character> CHARACTER_SET = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

    private final static List<Dim> dims = getDims();

    public void solveSudoku(char[][] board) {
        int i = 0;
        int count = 0;
        int tolerance = 0;
        int countAll = 0;
        do {
            count = isSolved(board);
            for (Dim dim : dims) {
                solve(board, dim, tolerance);
            }
            i++;
            countAll = isSolved(board);
            System.out.println("Iterations " + i + " unsolved " + countAll);

            printMatrix(board);
            if (countAll == count) {
                tolerance++;
            }
        } while (countAll > 0);


    }

    private void solve(char[][] board, Dim dim, int tolerance) {
        for (int i = dim.rowStart(); i < dim.rowEnd(); i++) {
            for (int j = dim.colStart(); j < dim.colEnd(); j++) {
                if (board[i][j] == '.') {
                    char c = findChar(board, dim, i, j, tolerance);
                    if (c != '.') {
                        board[i][j] = c;
                    }
                }
            }
        }
    }

    private char findChar(char[][] board, Dim dim, int i, int j, int tolerance) {
        char result = '.';

        Set<Character> subBoardMissingChars = charSetWithoutExisting(subBoardChars(board, dim));

        Set<Character> rowChars = rowChars(board, i);
        Set<Character> colChars = colChars(board, j);

        List<Character> possibleChars = getPossibleChars(subBoardMissingChars, rowChars, colChars);

        if (possibleChars.size() == 1) {
            return possibleChars.get(0);
        }

        if (tolerance > 0 && possibleChars.size() == tolerance) {
            for (int k = 0; k < tolerance; k++) {
                char[][] copyBoard = Arrays.stream(board).map(char[]::clone).toArray(char[][]::new);
                copyBoard[i][j] = result = possibleChars.get(k);

                if (isSolvable(copyBoard)) {
                    return possibleChars.get(k);
                }
            }
        }

        return result;
    }

    private boolean isSolvable(char[][] copyBoard) {
        int count = 0;
        int countAll = 0;
        int tolerance = 0;
        do {
            count = isSolved(copyBoard);
            for (Dim dim : dims) {
                solve(copyBoard, dim, tolerance);
            }
            countAll = isSolved(copyBoard);

            if(countAll == 0) {
                return true;
            }
            if (countAll == count) {
                tolerance++;
            }
        } while (countAll>0);

        return false;
    }

    private static List<Character> getPossibleChars(Set<Character> subBoardMissingChars, Set<Character> rowChars, Set<Character> colChars) {
        List<Character> possibleChars = new ArrayList<>();

        for (Character chr : subBoardMissingChars) {
            if (!rowChars.contains(chr) && !colChars.contains(chr)) {
                possibleChars.add(chr);
            }
        }
        return possibleChars;
    }

    private Set<Character> subBoardChars(char[][] board, Dim dim) {
        Set<Character> chars = new HashSet<>();
        for (int i = dim.rowStart(); i < dim.rowEnd(); i++) {
            for (int j = dim.colStart(); j < dim.colEnd(); j++) {
                if (board[i][j] != '.') {
                    chars.add(board[i][j]);
                }
            }
        }
        return chars;
    }

    private Set<Character> rowChars(char[][] board, int row) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != '.') {
                chars.add(board[row][i]);
            }
        }
        return chars;
    }

    private Set<Character> colChars(char[][] board, int col) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != '.') {
                chars.add(board[i][col]);
            }
        }
        return chars;
    }

    private static Set<Character> charSetWithoutExisting(Set<Character> forRemove) {
        return CHARACTER_SET.stream().filter(character -> !forRemove.contains(character)).collect(Collectors.toSet());
    }

    private int isSolved(char[][] board) {
        int count = 0;
        for (char[] row : board) {
            for (char c : row) {
                if (c == '.') {
                    count++;
                }
            }
        }
        return count;
    }

    private static List<Dim> getDims() {
        List<Dim> dims = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dims.add(new Dim(i * 3, (i * 3) + 3, j * 3, (j * 3) + 3));
            }
        }
        return dims;
    }

    public record Dim(int rowStart, int rowEnd, int colStart, int colEnd) {
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.','.','.','2','.','.','.','6','3'},
                {'3','.','.','.','.','5','4','.','1'},
                {'.','.','1','.','.','3','9','8','.'},
                {'.','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','3','8','.','.','.'},
                {'.','3','.','.','.','.','.','.','.'},
                {'.','2','6','3','.','.','5','.','.'},
                {'5','.','3','7','.','.','.','.','8'},
                {'4','7','.','.','.','1','.','.','.'}
        };

        new Solution().solveSudoku(board);

    }

    private static void printMatrix(char[][] board) {
        for (char[] chars : board) {
            StringBuilder line = new StringBuilder("[");
            for (int j = 0; j < chars.length; j++) {
                line.append(chars[j]);
                if (j != chars.length - 1) {
                    line.append('|');
                }
            }
            line.append(']');
            System.out.println(line);
        }
    }
}
