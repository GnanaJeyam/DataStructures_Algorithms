package com.jeyam.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://takeuforward.org/data-structure/4-sum-find-quads-that-add-up-to-a-target-value/
 */
public class FourSum {

    public static void main(String[] args) {
        int[] sums = {1,0,-1,0,-2,2};
        Arrays.sort(sums);
        int len = sums.length;
        var result = new ArrayList<List<Integer>>();

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int k = j+1;
                int l = len-1;

                while (k < l) {

                    int sum = sums[i] + sums[j] + sums[k] + sums[l];

                    if (sum == 0) {
                        result.add(List.of(sums[i] , sums[j] , sums[k] , sums[l]));
                        k++;
                        l--;

                        // skip same values in k index
                        while (k < l && sums[k] == sums[k-1]) {
                            k++;
                        }

                        // skip same values in l index
                        while (k < l && sums[l] == sums[l+1]) {
                            l--;
                        }
                    }
                    else if (sum > 0) {
                        l--;
                    } else {
                        k++;
                    }


                }
            }
        }

        System.out.println(result);
    }
}
