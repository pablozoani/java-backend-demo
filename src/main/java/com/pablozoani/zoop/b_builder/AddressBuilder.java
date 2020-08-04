package com.pablozoani.zoop.b_builder;

import com.pablozoani.zoop.reusable_entities.Address;

public interface AddressBuilder {

    AddressBuilder houseNumber(int houseNumber);

    AddressBuilder streetName(String streetName);

    AddressBuilder townName(String townName);

    AddressBuilder stateName(String stateName);

    AddressBuilder zipCode(String zipCode);

    Address build();
}
