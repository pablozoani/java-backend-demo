package com.pablozoani.z_other_oop.a_decorator;

/**
 * Decorator for phasor classes.
 */
public class SineWaveGenerator implements SignalGenerator {

    private Phasor phasor;

    /**
     * Construct an sine wave oscillator with the given phase generator.
     *
     * @param phasor
     */
    public SineWaveGenerator(Phasor phasor) {
        this.phasor = phasor;
    }

    /**
     * Generates a sine wave.
     *
     * @param cycles Number of cycles for this signal
     * @return The signal as an array of doubles.
     */
    @Override
    public double[] generate(double cycles) {
        double[] output = phasor.generate(cycles);

        for (int i = 0; i < output.length; i++) {
            output[i] = Math.sin(2 * Math.PI * output[i]);
        }

        return output;
    }
}
