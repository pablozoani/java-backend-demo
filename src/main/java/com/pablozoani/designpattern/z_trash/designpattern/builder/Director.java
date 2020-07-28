package com.pablozoani.designpattern.z_trash.designpattern.builder;

public class Director {

    private VehicleBuilder vehicleBuilder;

    public void construct(VehicleBuilder vehicleBuilder) {

        this.vehicleBuilder = vehicleBuilder;

        vehicleBuilder.startUpOperations();

        vehicleBuilder.buildBody();

        vehicleBuilder.insertWheels();

        vehicleBuilder.addHeadlights();

        vehicleBuilder.endOperations();
    }
}
