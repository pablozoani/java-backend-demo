package com.pablozoani.z_other_oop.z_trash.models.store;

import java.util.HashMap;

public class Aisle extends HashMap<String, Shelf> {

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Entry<String, Shelf> entry : this.entrySet())
            sb.append(entry.getKey()).append(":\n").append(entry.getValue());

        return sb.toString();
    }
}
