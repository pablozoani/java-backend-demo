package com.pablozoani.z_other_oop.z_trash.models.house.rooms;

import com.pablozoani.z_other_oop.z_trash.models.house.Dimensions;
import lombok.Getter;
import lombok.Setter;

public class BedRoom extends Room {

    @Getter
    @Setter
    private boolean withBalcony;

    @Getter
    @Setter
    private boolean withWardrobe;

    public BedRoom(Dimensions dimensions, int numberOfWindows, boolean withBalcony, boolean withWardrobe) {

        super(dimensions, numberOfWindows, RoomType.BEDROOM);

        this.withBalcony = withBalcony;

        this.withWardrobe = withWardrobe;
    }
}
