package com.pablozoani.zoop.z_trash.models.store;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class ProductImpl implements Product, Comparable<ProductImpl> {

    private static int counter = 0;

    @Getter
    private final int id = counter++;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private double price;

    @Getter
    @Setter
    private int stock;

    @Builder
    private ProductImpl(String description, double price, int stock) {

        this.description = description;

        this.price = price;

        this.stock = stock;
    }

    @Override
    public boolean sell() {
        return sell(1);
    }

    @Override
    public boolean sell(int n) {

        if (stock - n < 0) return false;

        stock -= n;

        return true;
    }

    @Override
    public boolean addStock(int n) {

        if (n < 0) return false;

        stock += n;

        return true;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProductImpl that = (ProductImpl) o;

        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(ProductImpl that) {
        return Integer.compare(this.id, that.id);
    }

    @Override
    public String toString() {
        return "id: " + id + ", description: " + description + ", price: $" + price;
    }
}
