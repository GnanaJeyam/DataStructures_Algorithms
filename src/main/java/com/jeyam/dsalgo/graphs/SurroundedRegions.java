package com.jeyam.dsalgo.graphs;


import static com.jeyam.dsalgo.graphs.GraphUtils.printMatrix;

/**
 * * https://takeuforward.org/graph/surrounded-regions-replace-os-with-xs/
 */
public class SurroundedRegions {

    /**
     * 1. Traverse all 4 boundaries of the grid and the value equal to 'O'.
     * 2. Top row -> Bottom row -> First Column -> Last Column
     * 3. If all boundaries are visited then whichever cell has 'O' should be replace.
     * 4. Replace all unvisited cell and if value == 'O', then replace with 'X'
     */

    public static void main(String[] args) {
        char grid [][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}
        };

        var n = grid.length;
        var m = grid[0].length;
        boolean visited [][] = new boolean[n][m];

        surroundRegion(grid, n, m, visited);

        System.out.println("Output :");
        printMatrix(grid);
    }

    private static void surroundRegion(char[][] grid,
                                       int n,
                                       int m,
                                       boolean visited [][]) {

        for (int i = 0; i < m; i++) {
            // Traverse the Top row and find all neighbour 'O'
            if (!visited[0][i] && grid[0][i] == 'O'){
                dfs(0, i, n, m, grid, visited);
            }

            // Traverse the Bottom row and find all neighbour 'O'
            if (!visited[n-1][i] && grid[n-1][i] == 'O') {
                dfs(n-1, i, n, m, grid, visited);
            }
        }

        for (int j = 0; j < n; j++) {
            // Traverse the First column and find all neighbour 'O'
            if (!visited[j][0] && grid[j][0] == 'O'){
                dfs(j, 0, n, m, grid, visited);
            }

            // Traverse the Last Column and find all neighbour 'O'
            if (!visited[j][m-1] && grid[j][m-1] == 'O') {
                dfs(j, m-1, n, m, grid, visited);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(int r,
                            int c,
                            int n,
                            int m,
                            char grid[][],
                            boolean visited [][]) {
        visited[r][c] = true;

        int rows [] = { -1, 0, 1, 0};
        int cols [] = {0, 1, 0, -1};

        for(int i=0; i<4; i++) {
           var cR = r + rows[i];
           var cC = c + cols[i];

           if (cR >=0 && cC >= 0 && cR < n && cC < m &&
               !visited[cR][cC] && grid[cR][cC] == 'O') {
               dfs(cR, cC, n, m, grid, visited);
           }
        }
    }
}
