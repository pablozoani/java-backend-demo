package com.pablozoani.z_other_oop.z_trash.designpattern.decorator2;

public class Main {

    public static void main(String[] args) {

        IceCream iceCream = new IceCreamPrefixer(new IceCreamSuffixer(new IceCreamImpl()));

        String output = iceCream.makeIceCream();

        System.out.println(output);
    }
}
