package com.pablozoani.zoop.a_decorator;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        System.out.println("Sine Wave:");

        SignalGenerator signalGenerator = new SineWaveGenerator(new Phasor(new double[8]));

        double[] samples = signalGenerator.generate(1);

        for (double d : samples) System.out.format(Locale.US, "%06.3f \n", d);

        System.out.println("\nTriangular Wave:");

        signalGenerator = new TriangularWaveGenerator(new Phasor(new double[8]));

        samples = signalGenerator.generate(1);

        for (double d : samples) System.out.format(Locale.US, "%06.3f \n", d);
    }
}
