package com.pablozoani.zoop.z_trash.models.artist;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public abstract class Artist<T extends Work> implements Producer<T> {

    protected Map<String, T> catalogue = new HashMap<>();

    @Getter @Setter
    protected String completeName;

    public Artist(String completeName) {
        this.completeName = completeName;
    }

    @Override
    public boolean produce(T work) {

        work.setArtistCompleteName(this.completeName);

        if (catalogue.containsKey(work.getTitle()) || catalogue.containsValue(work))
            return false;

        catalogue.put(work.getTitle(), work);

        return true;
    }
}
