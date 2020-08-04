package com.pablozoani.zoop.z_trash.models.house;


import com.pablozoani.zoop.z_trash.models.house.rooms.Kitchen;
import com.pablozoani.zoop.z_trash.models.house.rooms.Room;

public class Main {

    private static House firstHouse = new House();

    public static void main(String[] args) {

        Room theKitchen = Factory.kitchen(Factory.dimensions(4.6, 3.2, 2.6), 1, Kitchen.KitchenType.ELECTRIC);

        Room theDiningRoom = Factory.diningroom(Factory.dimensions(5.2, 4.3, 2.6), 2);

        Room theLivingRoom = Factory.livingroom(Factory.dimensions(4.3, 3.0, 2.6), 1, true);

        Floor firstFloor = Factory.floor(0, theKitchen, theDiningRoom, theLivingRoom);

        Room firstBedroom = Factory.bedroom(Factory.dimensions(3.5, 3.6, 2.4), 1, true, true);

        Room secondBedroom = Factory.bedroom(Factory.dimensions(3.5, 3.6, 2.4), 1, false, true);

        Room thirdBedroom = Factory.bedroom(Factory.dimensions(3.9, 3.7, 2.4), 1, true, true);

        Room theBathroom = Factory.bathroom(Factory.dimensions(2.0, 3.5, 2.4), 1, false);

        Floor secondFloor = Factory.floor(1, firstBedroom, secondBedroom, thirdBedroom, theBathroom);

        firstHouse.addFloor(firstFloor);

        firstHouse.addFloor(secondFloor);

        System.out.println(firstHouse);
    }
}
