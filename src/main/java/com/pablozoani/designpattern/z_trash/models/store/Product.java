package com.pablozoani.designpattern.z_trash.models.store;

public interface Product {

    /**
     * Sell a single product if stock is available
     *
     * @return true if the product was sold
     */
    boolean sell();

    /**
     * Sell n products if stock is available
     *
     * @param n - the number of products to sell
     * @return true if the products were sold
     */
    boolean sell(int n);

    /**
     * Add n products to the stock
     *
     * @param n - the number of products to add
     * @return false if n is negative
     */
    boolean addStock(int n);
}
