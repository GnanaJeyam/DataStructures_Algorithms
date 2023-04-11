package com.jeyam.dsalgo.graphs;

public class PairWithCount {
    private final int row;
    private final int col;
    private final int count;

    public PairWithCount(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getCount() {
        return count;
    }
}
