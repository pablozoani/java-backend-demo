package com.pablozoani.designpattern.z_trash.models.store;

import java.util.HashMap;

public class Store extends HashMap<String, Aisle> {

    @Override
    public Aisle put(String key, Aisle value) {
        return super.put(key.toLowerCase(), value);
    }

    @Override
    public Aisle get(Object key) {
        return super.get(((String) key).toLowerCase());
    }

    @Override
    public String toString() {
        StringBuilder sb =
            new StringBuilder("STORE\n");

        for (Entry<String, Aisle> entry : this.entrySet())
            sb.append(entry.getKey() + ": \n" + entry.getValue());

        return sb.toString();
    }
}
