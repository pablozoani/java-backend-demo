package com.pablozoani.z_other_oop.z_trash.models.artist;

public interface Performer<T extends Performable> {
    void perform(T performable);
}
