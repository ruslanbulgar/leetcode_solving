package com.rbcode.leatcode._48_rotate_image;

import java.util.Arrays;

public class Solution {
    public void rotateWithCopy(int[][] matrix) {

        int n = matrix.length;

        int[][] tempMatrix =
                Arrays.stream(matrix)
                        .map(int[]::clone)
                        .toArray(int[][]::new);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - 1 - i] = tempMatrix[i][j];
            }
        }
    }

    public void rotate(int[][] matrix) {
        final int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        sout(image);
        new Solution().rotate(image);
        sout(image);
        new Solution().rotate(image);
        sout(image);
        new Solution().rotate(image);
        sout(image);
        new Solution().rotate(image);
        sout(image);
    }

    private static void sout(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println(" ");
    }
}
