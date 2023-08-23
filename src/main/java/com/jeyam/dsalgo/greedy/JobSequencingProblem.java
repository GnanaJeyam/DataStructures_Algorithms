package com.jeyam.dsalgo.greedy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://takeuforward.org/data-structure/job-sequencing-problem/
 */
public class JobSequencingProblem {
    public static void main(String[] args) {
        int[][] seqs = {
            {1,2,100},
            {2,1,19},
            {3,2,27},
            {4,1,25},
            {5,1,15}
        };
        /**
         * 1. Convert the seq 2d array to list of Job object.
         * 2. Sort the jobs list with profit element.
         * 3. Track the maxDeadline from the jobs/seqs list.
         * 4. Iterate till the maxDeadline and for each iteration add the profit based on below condition.
         * 5. Check if the deadline is already present then add the profit and update the bucket with existing deadline value - 1
         * 6. Else add the profit to the result and add new entry with deadLine and its count (deadline-1)
         *
         * TC: O(N log N) + O(N)
         * SC: O(N) + O(N)
         */
        var jobs = new ArrayList<Job>();
        int maxDeadline = 0;

        for (int[] seq: seqs) {
            if (seq[1] > maxDeadline) {
                maxDeadline = seq[1];
            }
            jobs.add(new Job(seq[0], seq[1], seq[2]));
        }

        jobs.sort((a, b) -> b.profit() - a.profit());
        int start = 0;
        int result = 0;
        var bucket = new HashMap<Integer, Integer>();

        while (maxDeadline > 0) {
            var job = jobs.get(start);
            var deadLine = job.deadLine();
            var deadEntry = bucket.get(deadLine);

            if (deadEntry == null || deadEntry > 0) {
                if (deadEntry != null) {
                    result += job.profit();
                    bucket.put(deadLine, deadEntry-1);
                } else {
                    result += job.profit();
                    bucket.put(deadLine, deadLine-1);
                }
            }

            start++;
            maxDeadline--;
        }

        System.out.println("Result : " + result);
    }

    record Job(int jobId, int deadLine, int profit){}
}
