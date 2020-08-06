package com.pablozoani.z_other_oop.z_trash.models.house;

import lombok.Getter;

import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.TreeMap;

public class House implements Iterable<Floor> {

    private static int counter;

    @Getter
    private int id = counter++;

    private NavigableMap<Integer, Floor> floors = new TreeMap<>();

    public House() {
    }

    public boolean addFloor(Floor floor) {
        return floors.put(floor.getFloorNumber(), floor) != null;
    }

    public boolean removeFloor(int floorNumber) {
        return floors.remove(floorNumber) != null;
    }

    public Floor findFloor(int floorNumber) {
        return floors.get(floorNumber);
    }

    public NavigableMap<Integer, Floor> getFloors() {
        return Collections.unmodifiableNavigableMap(floors);
    }

    @Override
    public Iterator<Floor> iterator() {
        return floors.values()
                .iterator();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("House: ");

        for (Floor floor : floors.values())
            sb.append("\n").append(floor);

        return sb + "";
    }
}
