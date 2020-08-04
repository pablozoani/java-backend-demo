package com.pablozoani.zoop.z_trash.designpattern.decorator4;

public class Main {

    public static void main(String[] args) {

        OpenPTrackData openPTrackData = new OpenPTrackDataOffset(new OpenPTrackDataScale(new OpenPTrackDataImpl()));

        for (int i = 0; i < openPTrackData.id.length; i++) {
            System.out.println("id: " + openPTrackData.id[i] +
                               ", x: " + openPTrackData.x[i] + ", y: " + openPTrackData.y[i]);
        }
    }
}
