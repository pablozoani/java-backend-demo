package com.pablozoani.z_other_oop.a_decorator;

/**
 * Decorator for a phasor object.
 */
public class TriangularWaveGenerator implements SignalGenerator {

    private Phasor phasor;

    /**
     * Construct an triangular wave oscillator with the given phase generator.
     *
     * @param phasor
     */
    public TriangularWaveGenerator(Phasor phasor) {
        this.phasor = phasor;
    }

    /**
     * Generates a triangular wave.
     *
     * @param cycles Number of cycles for this signal
     * @return The signal as an array of doubles.
     */
    @Override
    public double[] generate(double cycles) {
        double[] output = phasor.generate(cycles);

        for (int i = 0; i < output.length; i++) {
            output[i] = 1 - Math.abs((output[i] * 2 - 1));
        }

        return output;
    }
}
