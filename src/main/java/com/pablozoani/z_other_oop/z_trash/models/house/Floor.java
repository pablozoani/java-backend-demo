package com.pablozoani.z_other_oop.z_trash.models.house;


import com.pablozoani.z_other_oop.z_trash.models.house.rooms.Room;

import java.util.Map;

public interface Floor extends Iterable<Room> {

    boolean addRoom(Room room);

    boolean removeRoom(int roomKey);

    Room findRoom(int roomKey);

    Map<Integer, Room> getRooms();

    int getFloorNumber();
}
