package com.pablozoani.zoop.z_trash.models.artist;

public interface Performer<T extends Performable> {
    public void perform(T performable);
}
