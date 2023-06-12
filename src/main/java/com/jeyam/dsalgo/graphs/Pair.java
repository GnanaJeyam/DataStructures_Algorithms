package com.jeyam.dsalgo.graphs;

import java.util.Objects;

public class Pair {
    private int r;
    private int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getC() {
        return c;
    }
    public int getR() {
        return r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (r != pair.r) return false;
        return c == pair.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "r=" + r +
                ", c=" + c +
            '}';
    }
}
