package com.jeyam.dsalgo.arrays;

public class SearchIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int ele = 3;
        int start = 0;
        int end = matrix.length;
        int mid = matrix[end/2][0];

        if (mid > ele) {
            end = matrix.length/2;
        } else if (mid < ele){
            start = matrix.length/2;
        } else {
            System.out.println("True");
        }

        for (int i = start; i < end; i++) {
            int a[] = matrix[i];
            int low = 0;
            int high = a.length-1;
            int center = 0;
            while (center >= low && center <= high) {
                center = (low + high)/2;
                if (a[center] > ele) {
                    high = center;
                } else if (a[center] < ele) {
                    low = center;
                }
                else {
                    System.out.println("Found");
                    return;
                }
            }
        }

        System.out.println("Not found");
    }
}
