package com.jeyam.dsalgo.arrays;

/**
 * https://takeuforward.org/data-structure/stock-buy-and-sell/
 */
public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] stocks = {7,6,4,3,1};
        var result = findBestStock(stocks);
        System.out.println("Result: " + result);
    }


    static int findBestStock(int[] stocks) {

        /**
         * 1. First we need track the minStock. i.e (MAX_VALUE for the first iteration)
         * 2. For each index check if minStock < stocks[i], if satisfies then update the minStock with current index value.
         * 3. Also check maxPro < (stocks[i] - minStock), if satisfies then update the maxPro value.
         * 4. Return the maxPro value.
         */

        int minStock = Integer.MAX_VALUE;
        int maxPro = 0;

        for (int stock: stocks) {
            minStock = Math.min(minStock, stock);
            maxPro = Math.max(maxPro, stock-minStock);
        }

        return maxPro;
    }
}
