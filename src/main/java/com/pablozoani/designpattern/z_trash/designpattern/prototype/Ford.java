package com.pablozoani.designpattern.z_trash.designpattern.prototype;

public class Ford extends BasicCar {

    private int basePrice = 10000;

    public Ford(String modelName) {
        super(modelName);
    }

    @Override
    public BasicCar clone() throws CloneNotSupportedException {
        return (Ford) super.clone();
    }
}
