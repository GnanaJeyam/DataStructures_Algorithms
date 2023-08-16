package com.jeyam.dsalgo.arrays;

/**
 * https://takeuforward.org/data-structure/grid-unique-paths-count-paths-from-left-top-to-the-right-bottom-of-a-matrix/
 */
public class GridUniquePath {

    public static void main(String[] args) {
        int row = 3;
        int col = 3;

        var gridUniquePaths = findGridUniquePaths(0, 0, row, col);
        System.out.println("Result: " + gridUniquePaths);

    }

    private static int findGridUniquePaths(int i, int j, int row, int col) {
        if (i >= row || j >= col) {
            return 0;
        }
        if (i == row-1 && j == col-1) {
           return 1;
        }
        return findGridUniquePaths(i+1, j, row, col) + findGridUniquePaths(i,j+1, row, col);
    }
}
