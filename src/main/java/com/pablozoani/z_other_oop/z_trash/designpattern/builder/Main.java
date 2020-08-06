package com.pablozoani.z_other_oop.z_trash.designpattern.builder;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder carBuilder = new CarBuilder("Fiat");

        director.construct(carBuilder);

        Product product1 = carBuilder.getVehicle();

        product1.showProduct();

        MotorCycleBuilder motorCycleBuilder = new MotorCycleBuilder("Kawasaki");

        director.construct(motorCycleBuilder);

        Product product2 = motorCycleBuilder.getVehicle();

        product2.showProduct();
    }
}
