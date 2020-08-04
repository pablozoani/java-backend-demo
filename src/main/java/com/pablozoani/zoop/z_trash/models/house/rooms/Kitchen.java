package com.pablozoani.zoop.z_trash.models.house.rooms;

import com.pablozoani.zoop.z_trash.models.house.Dimensions;
import lombok.Getter;
import lombok.Setter;

public class Kitchen extends Room {

    public enum KitchenType {ELECTRIC, GAS}

    @Getter
    @Setter
    private KitchenType kitchenType;

    public Kitchen(Dimensions dimensions, int numberOfWindows, KitchenType kitchenType) {

        super(dimensions, numberOfWindows, RoomType.KITCHEN);

        this.kitchenType = kitchenType;
    }
}
