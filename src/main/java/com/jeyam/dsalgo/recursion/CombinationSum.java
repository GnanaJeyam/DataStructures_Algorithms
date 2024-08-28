package com.jeyam.dsalgo.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int combinations[] = {2, 3, 6, 7};
        int target = 7;

        var lists = new ArrayList<List<Integer>>();
        findCombinations(combinations, 0, target, new ArrayList<>(), lists);
        System.out.println(lists);
    }

    private static void findCombinations(int[] combinations, int i, int target,
                                         ArrayList<Integer> integers,
                                         ArrayList<List<Integer>> lists) {

        if (i >= combinations.length || target < 0) {
            return;
        }

        if (i == combinations.length-1 && target == 0) {
            lists.add(new ArrayList<>(integers));
            return;
        }


        if (target - combinations[i] >= 0) {
            integers.add(combinations[i]);
            findCombinations(combinations, i, target-combinations[i], integers, lists);
            integers.remove(integers.size()-1);
        }

        findCombinations(combinations, i+1, target, integers, lists);
    }
}