package com.jeyam.dsalgo.graphs;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1
 */
public class FloodFills {

    public static void main(String[] args) {
        int image [][] = {
                {1, 1, 1, 1},
                {1, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 1, 1},
        };

        boolean visited[][] = new boolean[image.length][image[0].length];
        floodFill(image, visited, 1, 1, 2);
    }

    private static void floodFill(int[][] image, boolean[][] visited, int sR, int sC, int newColor) {

        int color = image[sR][sC];
        int result[][] = new int[image.length][image[0].length];

        var queue = new LinkedList<Pair>();
        queue.add(new Pair(sR, sC));

        while (!queue.isEmpty()) {
            var pair = queue.pop();
            var row = pair.getR();
            var col = pair.getC();
            result[row][col] = newColor;

            // Row Left
            if (col-1 >= 0 && image[row][col-1] == color && result[row][col-1] != newColor) {
                queue.add(new Pair(row, col-1));
                result[row][col-1] = newColor;
            }

            // Row right
            if (col+1 < image[0].length && image[row][col+1] == color && result[row][col+1] != newColor){
                queue.add(new Pair(row, col+1));
                result[row][col+1] = newColor;
            }

            // Column Up
            if (row-1 >= 0 && image[row-1][col] == color && result[row-1][col] != newColor) {
                queue.add(new Pair(row-1,col));
                result[row-1][col] = newColor;
            }

            // Column Down
            if (row+1 < image.length && image[row+1][col] == color && result[row+1][col] != newColor) {
                queue.add(new Pair(row+1,col));
                result[row+1][col] = newColor;
            }
        }

        System.out.println("Input " + Arrays.deepToString(image));
        System.out.println("Result " + Arrays.deepToString(result));

    }
}