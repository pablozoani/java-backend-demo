package com.pablozoani.z_other_oop.c_strategy;

/**
 * Class for holding and displaying baby names...
 */
public class BabyNameList {

    private StringArraySortAlgorithm sortAlgorithm;

    private String[] names;

    public BabyNameList(String[] names, StringArraySortAlgorithm sortAlgorithm) {
        this.names = names;
        this.sortAlgorithm = sortAlgorithm;
    }

    public void sortBabyNames() {
        sortAlgorithm.sort(names);
    }

    public void printBabyNames() {
        for (String s : names) System.out.println(s);
    }

    public void setSortAlgorithm(StringArraySortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }
}
