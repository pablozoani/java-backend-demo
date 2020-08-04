package com.pablozoani.zoop.z_trash.models.store;

import java.util.HashMap;

public class Aisle extends HashMap<String, Shelf> {

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Entry<String, Shelf> entry : this.entrySet())
            sb.append(entry.getKey() + ":\n" + entry.getValue());

        return sb.toString();
    }
}
