package com.jeyam.dsalgo.arrays;

import com.jeyam.dsalgo.graphs.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/
 */
public class MergeOverlappingIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{1,3}, {2,6}, {8,10},{15,18}};

        var pairs = bruteForce(intervals);

        System.out.println("Brute Force " + pairs);

        System.out.println("Optimal Approach :" + pairs);
    }

    private static List<List<Integer>> optimalApproach(int[][] intervals) {
        /**
         * TC: O(N logN) + O(N)
         * SC: O(N)
         */
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // If the pairs is empty or if it not applies to previous interval
            if (pairs.isEmpty() || intervals[i][0] > pairs.get(pairs.size()-1).get(1)) {
                pairs.add(List.of(intervals[i][0], intervals[i][1]));
            }
            // If the current interval intersect with previous interval
            else if (pairs.get(pairs.size()-1).get(1) >= intervals[i][0]) {
                pairs.set(pairs.size()-1, List.of(pairs.get(pairs.size()-1).get(0),
                    Math.max(intervals[i][1], pairs.get(pairs.size()-1).get(1))));
            }
        }

        return pairs;
    }

    private static List<List<Integer>> bruteForce(int[][] intervals) {
        /**
         * TC: O(N logN) + O(2N)
         * SC: O(N)
         */
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];

            if (!pairs.isEmpty()) {
                if(pairs.get(pairs.size()-1).get(1) >= end) {
                    continue;
                }
            }

            for (int j = i+1; j < intervals.length; j++) {
                int[] neighbour = intervals[j];
                if (end >= neighbour[0]){
                    end = Math.max(end, neighbour[1]);
                } else  {
                    break;
                }
            }

            pairs.add(new ArrayList<>(Arrays.asList(start, end)));
        }
        return pairs;
    }
}
