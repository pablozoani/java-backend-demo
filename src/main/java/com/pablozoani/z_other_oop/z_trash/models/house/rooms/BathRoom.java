package com.pablozoani.z_other_oop.z_trash.models.house.rooms;

import com.pablozoani.z_other_oop.z_trash.models.house.Dimensions;
import lombok.Getter;
import lombok.Setter;

public class BathRoom extends Room {

    @Getter
    @Setter
    private boolean withBathtub;

    public BathRoom(Dimensions dimensions, int numberOfWindows, boolean withBathtub) {

        super(dimensions, numberOfWindows, RoomType.BATHROOM);

        this.withBathtub = withBathtub;
    }
}
