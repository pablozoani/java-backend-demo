package com.pablozoani.designpattern.z_trash.models.store;

import java.util.ArrayList;

public class Shelf extends ArrayList<Product> {

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Product p : this)
            sb.append(p + "\n");

        return sb.toString();
    }
}