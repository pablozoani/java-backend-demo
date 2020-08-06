package com.pablozoani.z_other_oop.b_builder;

import com.pablozoani.z_other_oop.reusable_entities.Address;

public interface AddressBuilder {

    AddressBuilder houseNumber(int houseNumber);

    AddressBuilder streetName(String streetName);

    AddressBuilder townName(String townName);

    AddressBuilder stateName(String stateName);

    AddressBuilder zipCode(String zipCode);

    Address build();
}
