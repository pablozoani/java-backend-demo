package com.pablozoani.designpattern.z_trash.designpattern.decorator3;

public class FloorDecorator extends HouseDecorator {

    public FloorDecorator(House house) {
        super(house);
    }

    @Override
    public void makeHouse() {

        super.makeHouse();

        decorateFloor();
    }

    private void decorateFloor() {
        System.out.println("The floor is decorated.");
    }
}
