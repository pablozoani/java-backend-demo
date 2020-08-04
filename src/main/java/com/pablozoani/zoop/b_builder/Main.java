package com.pablozoani.zoop.b_builder;

import com.pablozoani.zoop.reusable_entities.Address;

public class Main {

    public static void main(String[] args) {

        AddressBuilder addressBuilder = AddressBuilders.getSimple();

        Address address = addressBuilder
            .houseNumber(1432)
            .streetName("Zeus Street")
            .townName("Athens")
            .stateName("Athens")
            .zipCode("10xxx")
            .build();

        System.out.println(address);

        System.out.println();

        addressBuilder = AddressBuilders.getCustom();

        address = addressBuilder
            .houseNumber(1432)
            .streetName("Zeus Street")
            .townName("Athens")
            .stateName("Athens")
            .zipCode("10xxx")
            .build();

        System.out.println(address);
    }
}
