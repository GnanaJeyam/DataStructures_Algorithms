package com.jeyam.dsalgo.graphs;

public final class GraphUtils {

    static int[] getRowIndexFor4Directions() {
        int rI[] = {0, 0, -1, 1};

        return rI;
    }

    static int[] getColumnIndexFor4Directions() {
        int cI[] = {-1, 1, 0, 0};

        return cI;
    }

    static void printMatrix(int grid[][]) {
        System.out.println("_ ".repeat(grid.length*3));

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print("| "+grid[i][j] +"  ");
            }
            System.out.print(" |");
            System.out.println();
            System.out.println("_ ".repeat(grid.length*3));
        }

    }
}
