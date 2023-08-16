package com.jeyam.dsalgo.arrays;

import java.util.*;
import java.util.stream.Stream;

public class ThreeSum {
    public static void main(String[] args) {
        int[] sums = { -1, 0, 1, 2, -1, -4};

        usingMap(sums);
        usingSorting(sums);
    }

    private static void usingSorting(int[] sums) {
        int length = sums.length;
        Arrays.sort(sums);
        var result = new ArrayList<List<Integer>>();

        for (int i = 0; i < length; i++) {

            // Skip duplicates in i section
            if (i!=0 && sums[i] == sums[i-1]) {
                continue;
            }

            int j = i+1;
            int k = length-1;

            while ( j < k) {
                var triplet = sums[i] + sums[j] + sums[k];
                if (triplet > 0) {
                    k--;
                } else if (triplet < 0) {
                    j++;
                }else {
                    result.add(List.of(sums[i] , sums[j], sums[k]));
                    j++;
                    k--;

                    // Skip duplicates in j section
                    while (j < k && sums[j] == sums[j-1]) {
                        j++;
                    }

                    // Skip duplicates in k section
                    while (j < k && sums[k] == sums[k+1]) {
                        k--;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static void usingMap(int[] sums) {
        int length = sums.length;

        var result = new HashSet<List<Integer>>();
        for (int i = 0; i < length; i++) {
            var bucket = new LinkedHashSet<Integer>();
            for (int j = i+1; j < length; j++) {
                int pair = -(sums[i] + sums[j]);
                if (bucket.contains(pair)) {
                    result.add(Stream.of(sums[i], sums[j], pair).sorted().toList());
                }
                bucket.add(sums[j]);
            }
        }

        System.out.println(result);
    }
}
