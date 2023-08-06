package com.jeyam.dsalgo.utils;

public final class ArrayUtils {

    private ArrayUtils() {
        // No one should create instance
    }

    public static void printArray(int[] array) {
        printArray(array, 0, array.length-1);
    }

    public static void printArray(int[] array, int start, int end) {
        if (array == null || array.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = start; i <= end; i++) {
            sb.append(array[i]);
            if (i != end) {
                sb.append(", ");
            }
        }
        sb.append("]");

        System.out.println(sb);
    }
}
