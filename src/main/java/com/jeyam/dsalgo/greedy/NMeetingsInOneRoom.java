package com.jeyam.dsalgo.greedy;

import java.util.ArrayList;

/**
 * https://takeuforward.org/data-structure/n-meetings-in-one-room/
 */
public class NMeetingsInOneRoom {

    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] =  {2,4,5,7,9,9};
        int n = 6;

        /**
         * 1. Sort based on end time and based on position if both are same
         * 2. For the first iteration, limit will be -1. Just update the end with limit.
         * 3. Remaining iteration check whether limit(prev end) is lesser than the current start.
         * 4. If the above condition satisfy, update the limit with current end.
         *
         * TC: O(N) for inserting + O(N logN ) for sorting + O(N)
         * SC: O(N)
         */

        var meetings = new ArrayList<Meeting>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i+1));
        }
        // Sort the meetings based on end time and if both are equal sort by position
        meetings.sort((a, b) -> {
            if (a.end() < b.end()) {
                return -1;
            } else if (a.end() > b.end()) {
                return 1;
            } else if (a.position() < b.position()) {
                return -1;
            }
            return 0;
        });

        int limit = -1;

        var result = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            var meeting = meetings.get(i);
            if (limit == -1) {
                limit = meeting.end();
                result.add(meeting.position());
            } else if (limit < meeting.start()) {
                result.add(meeting.position());
                limit = meeting.end();
            }
        }

        System.out.println("Result: " + result);
    }

    record Meeting(int start, int end, int position) {

    }
}
