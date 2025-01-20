package com.jeyam.dsalgo.graphs;

import java.util.LinkedList;

/**
 * * https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
 */
public class NoOfIslands {

    /**
     * ALGORITHM:
     * 1. Create a same size visited array to check whether it is already visited.
     * 2. For each node if it is marked as '1' which means land not water & not visited before do bfs.
     * 3. Do bfs from that node to all it's neighbour nodes in all the 8 directions.
     * 4. Check index of bound check if it is not visited before then add to the queue.
     * 5. Then for every node iteration if the value is '1' & it is not visited before then increment the
     * counter.
     */

    public static void main(String[] args) {
        int[][] islands = {
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {0, 0, 0, 0},
            {1, 0, 1, 1},
        };
        boolean[][] visited = new boolean[islands.length][islands[0].length];

        printTotalIslands(islands, visited);
    }

    static void printTotalIslands(int[][] islands, boolean[][] visited) {
        int totalIslands = 0;
        int rows = islands.length;
        int cols = islands[0].length;

        for (int i=0; i<islands.length; i++) {
            for (int j=0; j<islands[i].length; j++) {
                if (islands[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, islands, visited, rows, cols);
                    totalIslands++;
                }
            }
        }

        System.out.print("Total Islands are : " + totalIslands);
    }

    static void bfs(int row,
                    int col,
                    int islands[][],
                    boolean visited[][],
                    int rows,
                    int cols) {

        visited[row][col] = true;
        var queue = new LinkedList<Pair>();
        queue.add(new Pair(row, col));

        while (!queue.isEmpty()) {
            var pair = queue.pop();
            var cR = pair.getR();
            var cC = pair.getC();

            for (int dR=-1; dR<=1; dR++) {
                for (int dC=-1; dC<=1; dC++) {
                    var nR = cR + dR;
                    var nC = cC + dC;
                    var isValidIndex = nR >= 0 && nR < rows && nC >=0 && nC < cols;
                    if (isValidIndex && islands[nR][nC] == 1 && !visited[nR][nC]) {
                        visited[nR][nC] = true;
                        queue.add(new Pair(nR, nC));
                    }
                }
            }

        }
    }
}
