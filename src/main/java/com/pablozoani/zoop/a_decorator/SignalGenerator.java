package com.pablozoani.zoop.a_decorator;

/**
 * Interface for Signal Generators.
 */
public interface SignalGenerator {

    /**
     * Generates a periodic signal.
     * @param cycles Number of cycles for this signal
     * @return The signal as an array of doubles
     */
    double[] generate(double cycles);

}
