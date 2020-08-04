package com.pablozoani.zoop.z_trash.designpattern.decorator4;

public class OpenPTrackDataOffset extends OpenPTrackDataDecorator {

    public OpenPTrackDataOffset(OpenPTrackData openPTrackData) {

        super(openPTrackData);

        for (int i = 0; i < openPTrackData.id.length; i++) { // Process the data...

            openPTrackData.x[i] += 3;

            openPTrackData.y[i] += 3;
        }
    }
}
