package com.pablozoani.zoop.z_trash.models.house;


import com.pablozoani.zoop.z_trash.models.house.rooms.*;

public class Factory {

    public static Dimensions dimensions(double length, double width, double height) {
        return new Dimensions(length, width, height);
    }

    public static BedRoom bedroom(Dimensions dimensions, int numberOfWindows, boolean withBalcony,
                                  boolean withWardrobe) {
        return new BedRoom(dimensions, numberOfWindows, withBalcony, withWardrobe);
    }

    public static BathRoom bathroom(Dimensions dimensions, int numberOfWindows, boolean withBathtub) {
        return new BathRoom(dimensions, numberOfWindows, withBathtub);
    }

    public static Kitchen kitchen(Dimensions dimensions, int numberOfWindows, Kitchen.KitchenType kitchenType) {
        return new Kitchen(dimensions, numberOfWindows, kitchenType);
    }

    public static LivingRoom livingroom(Dimensions dimensions, int numberOfWindows, boolean withFireplace) {
        return new LivingRoom(dimensions, numberOfWindows, withFireplace);
    }

    public static DiningRoom diningroom(Dimensions dimensions, int numberOfWindows) {
        return new DiningRoom(dimensions, numberOfWindows);
    }

    public static Floor floor(int floorNumber, Room... rooms) {
        return new FloorImpl(floorNumber, rooms);
    }
}
