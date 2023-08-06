package com.jeyam.dsalgo.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZero {

    public static void main(String[] args) {
        int[][] matrix = {
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5}
        };
        int n = matrix.length;
        int m = matrix[0].length;
        updateMatrixZeroUsingBruteForce(n, m, Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new));
        updateMatrixZeroUsingBetterSolution(n, m, Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new));
        updateMatrixZeroUsingOptimalSolution(n, m, matrix);

    }

    private static void updateMatrixZeroUsingOptimalSolution(int n,
                                                             int m,
                                                             int[][] matrix) {

        /**
         * 1. Consider 0th row and 0th column as row index and column index.
         * 2. First iterate the 0th row and check if it has any 0 in it and update x flag.
         * 3. Then iterate the 0th column and check if it has any 0 in it and update y flag.
         * 4. Now skip 0th row array and column array and iterate the remaining portion array. i.e 1->n & 1->m
         * 5. If any cell has 0 then update the j index in the 0th row and i index in 0th column array.
         * 6. Iterate sub-array again and check if the 0[i] || i[0] has any 0, if it has then update the cell to 0.
         * 7. Check whether x flag is true then update the 0th row with zeroes.
         * 8. Check whether y flag is true then update the 0th column with zeroes.
         * TC: (N * M) + (N * M)
         * SC: O(1)
         */

        boolean x = false, y = false;
        // First column
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                y = true;
            }
        }
        // First row
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                x = true;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (x) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }

        if (y) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        System.out.println("Result using optimal solution:");
        Arrays.stream(matrix).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    private static void updateMatrixZeroUsingBetterSolution(int n, int m, int[][] matrix) {

        /**
         * 1. Create row index array with length n and col index array with length m.
         * 2. Iterate the matrix array and for each cell has 0 value then mark that flag
         * corresponding row and col index array.
         * 3. Iterate the array and check if the row index or col index has flag then replace
         * that index to 0
         *
         * TC: (N * M) + (N * M)
         * SC: O(n) + O(m)
         */
        boolean[] rIndex = new boolean[n];
        boolean[] cIndex = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rIndex[i] = true;
                    cIndex[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rIndex[i] || cIndex[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println("Result using better solution:");
        Arrays.stream(matrix).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    static void updateMatrixZeroUsingBruteForce(int n, int m, int[][] matrix) {
        /**
         * 1. For each cell if the value is 0 then mark that row & col to -1
         * except that indexes that has 0 value.
         * 2. Iterate again array and mark values from -1 to 0
         * TC: (N * M) * (N + M) + (N * M)
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markRowAndColumn(i, j, n, m, matrix);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println("Result using brute force:");
        Arrays.stream(matrix).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    private static void markRowAndColumn(int i, int j, int n, int m, int[][] matrix) {
        // mark row
        for (int k = 0; k < m; k++) {
            if (matrix[i][k] != 0) {
                matrix[i][k] = -1;
            }
        }

        // mark column
        for (int k = 0; k < n; k++) {
            if (matrix[k][j] != 0) {
                matrix[k][j] = -1;
            }
        }
    }
}
