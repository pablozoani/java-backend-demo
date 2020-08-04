package com.pablozoani.zoop.b_builder;

import com.pablozoani.zoop.reusable_entities.Address;

public class AddressBuilderImpl implements AddressBuilder {

    private Address address;

    public AddressBuilderImpl() {
        address = new Address();
    }

    public AddressBuilderImpl(Address address) {
        this.address = address;
    }

    @Override
    public AddressBuilder houseNumber(int houseNumber) {
        address.setHouseNumber(houseNumber);
        return this;
    }

    @Override
    public AddressBuilder streetName(String streetName) {
        address.setStreetName(streetName);
        return this;
    }

    @Override
    public AddressBuilder townName(String townName) {
        address.setTownName(townName);
        return this;
    }

    @Override
    public AddressBuilder stateName(String stateName) {
        address.setStateName(stateName);
        return this;
    }

    @Override
    public AddressBuilder zipCode(String zipCode) {
        address.setZipCode(zipCode);
        return this;
    }

    @Override
    public Address build() {
        Address output = address;
        return address;
    }
}
