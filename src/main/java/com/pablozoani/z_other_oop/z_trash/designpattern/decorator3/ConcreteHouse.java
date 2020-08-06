package com.pablozoani.z_other_oop.z_trash.designpattern.decorator3;

public class ConcreteHouse extends House {

    public ConcreteHouse() {

    }

    @Override
    public void makeHouse() {
        System.out.println("The house is completed.");
    }
}