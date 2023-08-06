package com.jeyam.dsalgo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/submissions/1011847964/
 */
public class PascalTriangle {

    public static void main(String[] args) {
        /**
         * 1. Add 1 in the start and end index.
         * 2. For each inner iteration, pick the above element from the list.
         * 3. Retrieve the left and above element.
         * 4. Add the left and above and put in the subElement list.
         * 5. Finally add subElement to the result.
         */
        int n = 5;
        var result = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            var subElement = new ArrayList<Integer>();
            for (int j = 0; j <= i ; j++) {
                if (j == 0 || j == i) {
                    subElement.add(1);
                }else {
                    int left = result.get(i-1).get(j-1);
                    int above = result.get(i-1).get(j);
                    subElement.add(left + above);
                }
            }
            result.add(subElement);
        }

        System.out.println(result);
    }
}
