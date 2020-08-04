package com.pablozoani.zoop.z_trash.designpattern.builder;

public interface VehicleBuilder {

    void startUpOperations();

    void buildBody();

    void insertWheels();

    void addHeadlights();

    void endOperations();

    Product getVehicle();
}
