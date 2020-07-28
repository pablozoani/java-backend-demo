package com.pablozoani.designpattern.c_strategy;

public class StringArraySortAlgorithms {

    public static StringArraySortAlgorithm getAlphabeticalAlgorithm() {
        return new AlphabeticalSort();
    }

    public static StringArraySortAlgorithm getLengthBasedAlgorithm() {
        return new LengthBasedSort();
    }
}
