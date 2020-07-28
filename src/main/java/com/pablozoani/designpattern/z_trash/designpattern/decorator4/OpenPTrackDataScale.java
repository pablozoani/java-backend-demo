package com.pablozoani.designpattern.z_trash.designpattern.decorator4;

public class OpenPTrackDataScale extends OpenPTrackDataDecorator {

    public OpenPTrackDataScale(OpenPTrackData openPTrackData) {

        super(openPTrackData);

        for (int i = 0; i < openPTrackData.id.length; i++) { // Process in another way...

            openPTrackData.x[i] *= 10;

            openPTrackData.y[i] *= 10;
        }
    }
}
