package com.pablozoani.z_other_oop.z_trash.models.artist;

public interface Producer<T extends Work> {

    /**
     * Adds a work to the artist's catalogue.
     *
     * @param work
     * @return true if the work was added
     */
    boolean produce(T work);
}
