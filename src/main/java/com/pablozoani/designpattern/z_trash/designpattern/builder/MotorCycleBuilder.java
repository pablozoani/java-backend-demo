package com.pablozoani.designpattern.z_trash.designpattern.builder;

public class MotorCycleBuilder implements VehicleBuilder {

    private String brandName;

    private Product product;

    public MotorCycleBuilder(String brandName) {

        product = new Product();

        this.brandName = brandName;
    }

    @Override
    public void startUpOperations() {
        product.add(String.format("MotorCycleBuilder %s operations are beginning...", brandName));
    }

    @Override
    public void buildBody() {
        product.add("MotorCycle body added");
    }

    @Override
    public void insertWheels() {
        product.add("2 wheels added");
    }

    @Override
    public void addHeadlights() {
        product.add("1 headlights added");
    }

    @Override
    public void endOperations() {
        product.add("The MotorCycle was painted");
    }

    @Override
    public Product getVehicle() {
        return product;
    }
}