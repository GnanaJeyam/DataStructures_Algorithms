package com.jeyam.dsalgo.greedy;

/**
 * https://takeuforward.org/data-structure/find-minimum-number-of-coins/
 */
public class FindMinimumNoOfCoins {
    public static void main(String[] args) {
        int coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int coinIndex = coins.length - 1;
        int total = 121;
        int min = 0;

        do {
            if (coins[coinIndex] > total) {
                coinIndex--;
            } else {
                var coinValue = coins[coinIndex];
                total = total - coinValue;
                min++;

                if (total < coinValue) {
                    coinIndex--;
                }
            }
        } while (total > 0);

        System.out.println("Result :" + min);
    }
}
