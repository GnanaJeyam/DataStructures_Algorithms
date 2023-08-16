package com.jeyam.dsalgo.arrays;

public class CountInversions {
    public static void main(String[] args) {
        int array[] = {5,4,3,2,1};
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j=i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    res++;
                }
            }
        }

        System.out.println("Result :"+ res);
    }
}
