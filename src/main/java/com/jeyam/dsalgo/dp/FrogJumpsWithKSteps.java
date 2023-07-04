package com.jeyam.dsalgo.dp;

public class FrogJumpsWithKSteps {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[] heights = new int[] {10,30, 40, 50, 20};

        System.out.println(frogJump(n, k, heights));

    }

    static int frogJump(int n, int k, int heights[]) {

        if (n == 0) {
            return 0;
        }

        int minimum = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int index = n-1;
            if (index >= 0) {
                minimum = Math.min(minimum, frogJump(n-1, k, heights ) + Math.abs(heights[i] - heights[index]));
            }
        }

        return minimum;
    }
}