package com.pablozoani.z_other_oop.z_trash.designpattern.prototype;

import java.util.Random;

public abstract class BasicCar implements Cloneable {

    private String modelName;

    private int basePrice;

    private int onRoadPrice;

    public BasicCar(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public static int setAdditionalPrice() {
        return new Random().nextInt(10000);
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public void setOnRoadPrice(int onRoadPrice) {
        this.onRoadPrice = onRoadPrice;
    }

    @Override
    public BasicCar clone() throws CloneNotSupportedException {
        return (BasicCar) super.clone();
    }

    @Override
    public String toString() {
        return "BasicCar{" +
                "modelName='" + modelName + '\'' +
                ", basePrice=" + basePrice +
                ", onRoadPrice=" + onRoadPrice +
                '}';
    }
}
