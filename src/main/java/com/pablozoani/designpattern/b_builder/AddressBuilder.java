package com.pablozoani.designpattern.b_builder;

import com.pablozoani.designpattern.reusable_entities.Address;

public interface AddressBuilder {

    AddressBuilder houseNumber(int houseNumber);

    AddressBuilder streetName(String streetName);

    AddressBuilder townName(String townName);

    AddressBuilder stateName(String stateName);

    AddressBuilder zipCode(String zipCode);

    Address build();
}
