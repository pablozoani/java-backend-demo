package com.pablozoani.z_other_oop.z_trash.designpattern.singleton;

public final class Captain {

    private static Captain captain;

    private Captain() {

    }

    public static synchronized Captain getInstance() {

        if (captain == null) return captain = new Captain();

        else return captain;
    }

    public static void main(String[] args) {

        Captain captain1 = Captain.getInstance();

        Captain captain2 = Captain.getInstance();

        System.out.println("Captain 1 and Captain 2 are the same object? " +
                (captain1 == captain2));
    }
}
