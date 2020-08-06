package com.pablozoani.z_other_oop.z_trash.models.house.rooms;


import com.pablozoani.z_other_oop.z_trash.models.house.Dimensions;

public class DiningRoom extends Room {

    public DiningRoom(Dimensions dimensions, int numberOfWindows) {
        super(dimensions, numberOfWindows, RoomType.DINING_ROOM);
    }
}
