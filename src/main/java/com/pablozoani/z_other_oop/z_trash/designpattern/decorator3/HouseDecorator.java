package com.pablozoani.z_other_oop.z_trash.designpattern.decorator3;

public abstract class HouseDecorator extends House {

    protected House house;

    public HouseDecorator(House house) {
        this.house = house;
    }

    public void makeHouse() {
        if (house != null)
            house.makeHouse();
    }
}
