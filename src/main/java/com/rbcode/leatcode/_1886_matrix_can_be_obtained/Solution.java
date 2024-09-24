package com.rbcode.leatcode._1886_matrix_can_be_obtained;

import java.util.Arrays;

public class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 3; i++) {
            if (isEquals(mat, target)) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }

    private boolean isEquals(int[][] mat, int[][] target) {
        if (mat.length != target.length) {
            return false;
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }

        return true;
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
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
}
