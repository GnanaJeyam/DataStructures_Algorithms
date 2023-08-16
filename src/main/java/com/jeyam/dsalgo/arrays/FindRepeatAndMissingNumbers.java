package com.jeyam.dsalgo.arrays;

import com.jeyam.dsalgo.utils.ArrayUtils;

public class FindRepeatAndMissingNumbers {

    public static void main(String[] args) {
        int[] numbers = {3,1,2,5,3};

        var length = numbers.length;
        int[] count = new int[length +1];

        for (int number : numbers) {
            count[number]++;
        }

        int[] result = new int[2];
        for (int i=1; i < count.length; i++) {
            if (count[i] == 0) {
                result[1] = i;
            } else if (count[i] > 1) {
                result[0] = i;
            }
        }

        ArrayUtils.printArray(result);
    }
}
