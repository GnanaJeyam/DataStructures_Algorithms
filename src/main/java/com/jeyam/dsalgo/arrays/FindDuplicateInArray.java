package com.jeyam.dsalgo.arrays;

/**
 * https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
 */
public class FindDuplicateInArray {

    public static void main(String[] args) {
        int[] array = {1,3,4,2,2};

        var result = betterApproach(array);
        System.out.println("Better Approach" +result);
    }

    private static int betterApproach(int[] array) {
        /**
         * TC: O(n)
         * SC: O(1)
         */
        int slow = array[0];
        int fast = array[0];

        // Move slow pointer by 1 and fast pointer by 2 till collision occur
        do {
            slow = array[slow];
            fast = array[array[fast]];
        }
        while (slow != fast);

        // After collision, reassign fast to array[0] and move both pointer in the same pace by 1.
        fast = array[0];
        while (fast != slow) {
            slow = array[slow];
            fast = array[fast];
        }

        return fast;
    }
}
