package com.pablozoani.zoop.z_trash.models.house;

import com.pablozoani.zoop.z_trash.models.house.rooms.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class FloorImpl implements Floor {

    private static int counter;

    @Getter
    private final int id = counter++;

    private int roomKey = 0;

    private final NavigableMap<Integer, Room> rooms = new TreeMap<>();

    @Getter
    @Setter
    private int floorNumber;

    public FloorImpl(int floorNumber, Room... rooms) {

        this.floorNumber = floorNumber;

        for (int i = 0; i < rooms.length; i++)
            this.rooms.put(roomKey++, rooms[i]);
    }

    @Override
    public boolean addRoom(Room room) {
        return rooms.put(roomKey++, room) != null;
    }

    @Override
    public boolean removeRoom(int roomKey) {
        return rooms.remove(roomKey) != null;
    }

    @Override
    public Room findRoom(int roomKey) {

        Room theRoom = rooms.get(roomKey);

        if (theRoom == null) {

            System.out.println("Couldn't find that room!");

            return null;
        }

        return theRoom;
    }

    @Override
    public Map<Integer, Room> getRooms() {
        return Collections.unmodifiableNavigableMap(rooms);
    }

    @Override
    public Iterator<Room> iterator() {
        return rooms.values()
                    .iterator();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Floor Number: " + floorNumber);

        for (Map.Entry<Integer, Room> entry : rooms.entrySet())
            sb.append("\n" + entry.getKey() + " " + entry.getValue());

        return sb + "";
    }
}
