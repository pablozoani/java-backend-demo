package com.pablozoani.zoop;

public enum Singleton {

    INSTANCE;

    private final String string = "Singleton";

    @Override
    public String toString() {
        return string;
    }

    public static void main(String[] args) {

        Singleton singleton = Singleton.INSTANCE;

        System.out.println(singleton);
    }
}
