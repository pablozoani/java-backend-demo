package com.pablozoani.designpattern.z_trash.designpattern.decorator3;

public class Main {

    public static void main(String[] args) {

        House house = new ConcreteHouse();

        house.makeHouse();

        HouseDecorator houseWithFloor = new FloorDecorator(house);

        houseWithFloor.makeHouse();

        HouseDecorator paintedHouse = new PaintDecorator(houseWithFloor);

        paintedHouse.makeHouse();
    }
}