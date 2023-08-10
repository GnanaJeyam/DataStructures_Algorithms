package com.jeyam.dsalgo.arrays;

import static com.jeyam.dsalgo.utils.ArrayUtils.print2DArray;

public class RotateImageBy90 {
    public static void main(String[] args) {
        int arr[][] =  {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        bruteForceApproach(arr);
        optimalApproach(arr);
    }

    private static void optimalApproach(int[][] arr) {
        /**
         * TC: O(N2) + O(N*N)
         * SC: O(1)
         */
        var length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i = 0; i < length; i++) {
            int[] row = arr[i];
            int start = 0, end = row.length-1;
            while (start <= end) {
                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;
                start++;
                end--;
            }
        }

        print2DArray(arr);
    }

    private static void bruteForceApproach(int[][] arr) {
        /**
         * TC: O(N2) || O(N*N)
         * SC: O(N*N)
         */
        var length = arr.length;
        int[][] clone = new int[length][arr[0].length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < clone[i].length; j++) {
                clone[j][length -i-1] = arr[i][j];
            }
        }

        print2DArray(clone);
    }
}
