package com.pablozoani.designpattern.b_builder;

import com.pablozoani.designpattern.reusable_entities.Address;

import static com.pablozoani.utils.ConsoleColors.*;

/**
 * Address Builder Factory
 */
public class AddressBuilders {

    /**
     * Get a simple address builder with JSON like toString().
     * @return the address builder
     */
    public static AddressBuilder getSimple() {
        return new AddressBuilderImpl();
    }

    /**
     * Get an address builder with custom toString();
     * @return the address builder
     */
    public static AddressBuilder getCustom() {
        Address address = new Address() {
            @Override
            public String toString() {
                return RED_UNDERLINED + "House Number: " + getHouseNumber() + ", Street: " + getStreetName() +
                       ", Town: " + getTownName() + ", State: " + getStateName() + ", Zip Code: " +
                       getZipCode() + "." + RESET;
            }
        };

        return new AddressBuilderImpl(address);
    }
}
