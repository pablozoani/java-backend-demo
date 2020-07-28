package com.pablozoani.designpattern.z_trash.models.house.rooms;


import com.pablozoani.designpattern.z_trash.models.house.Dimensions;

public class DiningRoom extends Room {

    public DiningRoom(Dimensions dimensions, int numberOfWindows) {
        super(dimensions, numberOfWindows, RoomType.DINING_ROOM);
    }
}
