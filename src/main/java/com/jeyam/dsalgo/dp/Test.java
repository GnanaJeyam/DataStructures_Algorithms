package com.jeyam.dsalgo.dp;

public class Test {


    public static void main(String[] args) {
        int a[] = new int[] {3, 1, 5, 6, 2, 3};
        int maxVal = -1;
        for (int i = 0; i < a.length; i++) {
            int c = Integer.MAX_VALUE;
            for (int j = i; j < a.length; j++) {
                c = Math.min(c, a[j]);
                int width = j - i + 1;
                maxVal = Math.max(maxVal, c * width);
            }
        }

        System.out.println("SSSS-----" + maxVal);
    }
}
