package com.pablozoani.z_other_oop.z_trash.models.house.rooms;

import com.pablozoani.z_other_oop.z_trash.models.house.Dimensions;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public abstract class Room implements Comparable<Room> {

    private static int counter = 0;

    @Getter
    private int id = counter++;

    @Getter
    @Setter
    private Dimensions dimensions;

    @Getter
    @Setter
    private int numberOfWindows;

    @Getter
    @Setter
    private RoomType roomType;

    protected Room(Dimensions dimensions, int numberOfWindows, RoomType roomType) {

        this.dimensions = dimensions;

        this.numberOfWindows = numberOfWindows;

        this.roomType = roomType;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return id == room.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(@NotNull Room that) {
        return Integer.compare(this.id, that.id);
    }

    @Override
    public String toString() {
        return "Room type: " + roomType + ", Dimensions: [" + dimensions + "]";
    }
}
