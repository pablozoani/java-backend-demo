package com.pablozoani.z_other_oop.z_trash.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private List<String> parts;

    public Product() {
        parts = new ArrayList<>();
    }

    public void add(String part) {
        parts.add(part);
    }

    public void showProduct() {

        System.out.println("\nProducts completed as below:");

        for (String part : parts)
            System.out.println(part);
    }
}
