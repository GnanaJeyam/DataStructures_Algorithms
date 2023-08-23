package com.jeyam.dsalgo.greedy;

import java.util.ArrayList;

/**
 * https://takeuforward.org/data-structure/fractional-knapsack-problem-greedy-approach/
 */
public class FractionalKnapSack {
    public static void main(String[] args) {
        int values[] = {100,60,120};
        int weight[] = {20,10,30};
        int w = 50;
        int n = weight.length;

        /**
         * 1. Create arraylist of KnapSack for each value and it's corresponding weight.
         * 2. Sort the list in DESC order based on value/weight.
         * 3. Iterate the list and add currentWeight and finalValue based on two conditions.
         * 4. If the currentWeight + incomingWeight <= totalWeight then add both currentWeight and finalValue.
         * 5. Else get the remaining weight left by (totalWeight - currentWeight).
         * 6. Get the single weight value by incomingValue / incomingWeight.
         * 7. Multiply both the values and add it to the finalValue.
         *
         * TC: O(N log N) + O(N)
         * SC: O(N)
         */
        var sacks = new ArrayList<KnapSack>();
        for (int i = 0; i < n; i++) {
            sacks.add(new KnapSack(values[i], weight[i]));
        }

        sacks.sort((a, b) -> {
            double leftAvg = (double) a.value() / (double) a.weight();
            double rightAvg = (double) b.value() / (double) b.weight();

            if (leftAvg > rightAvg) {
                return -1;
            } else if (leftAvg < rightAvg) {
                return 1;
            }

            return 0;
        });

        double finalValue = 0;
        int currentWeight = 0;

        for (int i = 0; i < n; i++) {
            var sack = sacks.get(i);
            if (currentWeight + sack.weight() <= w) {
                currentWeight += sack.weight();
                finalValue += sack.value();
            } else {
                int singleWeight = sack.value() / sack.weight();
                finalValue +=  ( w - currentWeight ) * singleWeight;
                break;
            }
        }

        System.out.println( "Result :" + finalValue);
    }

    record KnapSack(int value, int weight){}
}
