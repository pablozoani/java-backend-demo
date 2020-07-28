package com.pablozoani.designpattern.z_trash.designpattern.prototype;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        BasicCar nano = new Nano("Green Nano");

        BasicCar ford = new Ford("Yellow Ford");

        nano.setBasePrice(10_000);

        ford.setBasePrice(50_000);

        BasicCar bc1;

        bc1 = nano.clone();

        bc1.setOnRoadPrice(nano.getBasePrice() + BasicCar.setAdditionalPrice());

        System.out.println(bc1);

        bc1 = ford.clone();

        bc1.setOnRoadPrice(ford.getBasePrice() + BasicCar.setAdditionalPrice());

        System.out.println(bc1);
    }
}
