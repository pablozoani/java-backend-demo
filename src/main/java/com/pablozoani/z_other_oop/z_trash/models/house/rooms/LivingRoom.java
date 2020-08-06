package com.pablozoani.z_other_oop.z_trash.models.house.rooms;

import com.pablozoani.z_other_oop.z_trash.models.house.Dimensions;
import lombok.Getter;
import lombok.Setter;

public class LivingRoom extends Room {

    @Getter
    @Setter
    private boolean withFireplace;

    public LivingRoom(Dimensions dimensions, int numberOfWindows, boolean withFireplace) {

        super(dimensions, numberOfWindows, RoomType.LIVING_ROOM);

        this.withFireplace = withFireplace;
    }
}
