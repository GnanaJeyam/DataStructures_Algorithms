package com.jeyam.dsalgo.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class NextPermutation {
    public static void main(String[] args) {
        Integer[] array = {1,1,5};
        var clone = array.clone();

        Arrays.sort(clone);
        List<Integer[]> result = new ArrayList<>();

        findPermutation(0, array.length, clone, result);

        result = result.stream().sorted((a, b) -> {
            for (int i = 0; i < a.length; i++) {
                int out = a[i].compareTo(b[i]);
                if (out != 0) {
                    return out;
                }
            }

            return Integer.compare(a.length, b.length);
        }).collect(Collectors.toList());

        // Check whether it is matching the last array index then we should return 1st entry
        var lastArray = result.get(result.size() - 1);
        if (Arrays.equals(array, lastArray)) {
            System.out.println("Result : " + Arrays.toString(result.get(0)));
        } else {
            int r = 0;
            for (int k = 0; k < result.size(); k++) {
                if (Arrays.equals(array, result.get(k))){
                    r = k;
                }
            }
            System.out.println("Result : " + Arrays.toString(result.get(r+1)));
        }
    }

    private static void findPermutation(int l, int h, Integer[] clone, List<Integer[]> result) {
       if(l >= h) {
           result.add(clone.clone());
           return;
       }

        for (int i = l; i <h; i++) {
            swap(i, l, clone);
            findPermutation(l+1, h, clone, result);
            swap(i, l, clone);
        }
    }

    private static void swap(int l, int h, Integer[] clone) {
        int temp = clone[l];
        clone[l] = clone[h];
        clone[h] = temp;
    }
}
