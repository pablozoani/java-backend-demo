package com.pablozoani.zoop.c_strategy;

import javax.validation.constraints.NotEmpty;

public class AlphabeticalSort implements StringArraySortAlgorithm {

    /**
     * Sort the strings alphabetically.
     * @param input the array to sort.
     * @return the same array, sorted.
     */
    @Override
    public String[] sort(@NotEmpty String[] input) {
        return mergeSort(input);
    }

    /**
     * Merge and conquer sort. Nulls go first.
     * @param input to be sorted.
     * @return the same array, sorted.
     */
    private String[] mergeSort(String[] input) {

        if (input.length == 1) return input;

        String[] leftSide = new String[input.length / 2];

        String[] rightSide = new String[input.length - leftSide.length];

        System.arraycopy(input, 0, leftSide, 0, leftSide.length);

        System.arraycopy(input, leftSide.length, rightSide, 0, rightSide.length);

        mergeSort(leftSide);

        mergeSort(rightSide);

        int inputIndex = 0;

        int leftIndex = 0;

        int rightIndex = 0;

        while (leftSide.length > leftIndex && rightSide.length > rightIndex) {

            if (leftSide[leftIndex] == null ||
                (rightSide[rightIndex] != null && leftSide[leftIndex].compareToIgnoreCase(rightSide[rightIndex]) < 0)) {

                input[inputIndex++] = leftSide[leftIndex++];

            } else {

                input[inputIndex++] = rightSide[rightIndex++];

            }
        }

        while (leftSide.length > leftIndex) {

            input[inputIndex++] = leftSide[leftIndex++];

        }

        while(rightSide.length > rightIndex) {

            input[inputIndex++] = rightSide[rightIndex++];

        }

        return input;
    }
}
