package com.pablozoani.designpattern.reusable_entities;

public class Address {

    private int houseNumber;

    private String streetName;

    private String townName;

    private String stateName;

    private String zipCode;

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address = {\n\tHouse Number: " + houseNumber + ",\n\tStreet: " +
               streetName + ",\n\tTown: " + townName + ",\n\tState: " + stateName +
               "\n\tZip Code: " + zipCode + "\n}";
    }
}
