package com.pablozoani.zoop.c_strategy;

public class Main {

    public static void main(String[] args) {

        BabyNameList babies =
            new BabyNameList(new String[]{"Oliver", "Charlotte", "Liam", "Ava", "Ethan",
                                          null, "Emilia", "Aiden", "Olivia"},
                             StringArraySortAlgorithms.getAlphabeticalAlgorithm());

        babies.sortBabyNames();

        System.out.println("== Alphabetically sorted ==");

        babies.printBabyNames();

        babies.setSortAlgorithm(StringArraySortAlgorithms.getLengthBasedAlgorithm());

        babies.sortBabyNames();

        System.out.println("\n== Sort based on the name length ==");

        babies.printBabyNames();

        // reverse babies algorithm with lambda:
        babies.setSortAlgorithm(strings -> {

            if (strings == null || strings.length == 0)
                throw new IllegalArgumentException("argument must be a non empty array of strings");

            String temp;

            for (int i = 0; i < strings.length / 2; i++) {

                temp = strings[i];

                strings[i] = strings[strings.length - i - 1];

                strings[strings.length - i - 1] = temp;
            }

            return strings;
        });

        babies.sortBabyNames();

        System.out.println("\n== Reversed order of baby names ==");

        babies.printBabyNames();
    }
}
