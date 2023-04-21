package com.jeyam.dsalgo.graphs;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairWithCount that = (PairWithCount) o;
        return row == that.row && col == that.col && count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, count);
    }
}
