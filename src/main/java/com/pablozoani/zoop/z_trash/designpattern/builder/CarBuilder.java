package com.pablozoani.zoop.z_trash.designpattern.builder;

public class CarBuilder implements VehicleBuilder {

    private String brandName;

    private Product product;

    public CarBuilder(String brandName) {

        product = new Product();

        this.brandName = brandName;
    }

    @Override
    public void startUpOperations() {
        product.add(String.format("CarBuilder %s parts are now in the factory", brandName));
    }

    @Override
    public void buildBody() {
        product.add("This is the body of the car");
    }

    @Override
    public void insertWheels() {
        product.add("4 wheels were added");
    }

    @Override
    public void addHeadlights() {
        product.add("2 headlights were added");
    }

    @Override
    public void endOperations() {
        product.add("the car was painted");
    }

    @Override
    public Product getVehicle() {
        return product;
    }
}
