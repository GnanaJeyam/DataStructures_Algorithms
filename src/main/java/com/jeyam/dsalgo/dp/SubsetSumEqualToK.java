package com.jeyam.dsalgo.dp;

public class SubsetSumEqualToK {

    public static void main(String[] args) {
        int[] subsets = {6, 1, 2, 1};
        int n = subsets.length;
        int k = 4;

        boolean result = findSubsetSum(n-1, k, subsets);

        System.out.println("Final result :" + (result ? "Presented" : "Not Presented"));
    }

    private static boolean findSubsetSum(int index,
                                         int target,
                                         int[] subsets) {

        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return subsets[0] == target;
        }

        boolean notTake = findSubsetSum(index - 1, target, subsets);

        boolean take = false;

        if (target >= subsets[index]) {
            take = findSubsetSum(index-1, target-subsets[index], subsets);
        }

        return notTake || take;
    }
}
