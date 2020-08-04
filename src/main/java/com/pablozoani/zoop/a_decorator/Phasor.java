package com.pablozoani.zoop.a_decorator;

/**
 * Class for generating a sawtooth wave.
 */
public class Phasor implements SignalGenerator {

    private final double[] buffer;

    /**
     * Create an instance of Phasor with the given buffer.
     * @param buffer
     */
    public Phasor(double[] buffer) {
        this.buffer = buffer;
    }

    /**
     * Generates a sawtooth wave whose range is from 0 to 1.
     * @param cycles Number of cycles for this signal
     * @return The signal as an array of doubles
     */
    @Override
    public double[] generate(double cycles) {

        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (i * cycles / buffer.length) % 1;
        }

        double[] output = new double[buffer.length];

        System.arraycopy(buffer, 0, output, 0, buffer.length);

        return output;
    }
}
