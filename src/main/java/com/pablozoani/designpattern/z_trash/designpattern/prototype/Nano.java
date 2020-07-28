package com.pablozoani.designpattern.z_trash.designpattern.prototype;

public class Nano extends BasicCar {

    private int basePrice = 10000;

    public Nano(String modelName) {
        super(modelName);
    }

    @Override
    public BasicCar clone() throws CloneNotSupportedException {
        return (Nano) super.clone();
    }
}
