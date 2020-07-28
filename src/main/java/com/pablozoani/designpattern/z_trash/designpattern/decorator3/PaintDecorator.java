package com.pablozoani.designpattern.z_trash.designpattern.decorator3;

public class PaintDecorator extends HouseDecorator {

    public PaintDecorator(House house) {
        super(house);
    }

    @Override
    public void makeHouse() {

        super.makeHouse();

        paintHouse();
    }

    private void paintHouse() {
        System.out.println("The house is painted.");
    }
}
