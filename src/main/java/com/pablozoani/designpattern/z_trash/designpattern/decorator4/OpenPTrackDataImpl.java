package com.pablozoani.designpattern.z_trash.designpattern.decorator4;

import java.util.Random;

public class OpenPTrackDataImpl extends OpenPTrackData {

    public OpenPTrackDataImpl() {

        id = new int[5];

        x = new double[5];

        y = new double[5];

        final Random random = new Random();

        for (int i = 0; i < id.length; i++) {

            id[i] = random.nextInt();

            x[i] = random.nextDouble();

            y[i] = random.nextDouble();
        }
    }
}
