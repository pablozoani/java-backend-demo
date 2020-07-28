package com.pablozoani.designpattern.z_trash.designpattern.decorator4;

public abstract class OpenPTrackDataDecorator extends OpenPTrackData {

    private OpenPTrackData openPTrackData;

    public OpenPTrackDataDecorator(OpenPTrackData openPTrackData) {

        this.openPTrackData = openPTrackData;

        id = openPTrackData.id; // copy the memory address of each array...

        x = openPTrackData.x;

        y = openPTrackData.y;
    }
}
