package com.pablozoani.z_other_oop.z_trash.models.artist;

import lombok.Getter;
import lombok.Setter;

public class Composer extends Artist<MusicPiece> implements Performer<MusicPiece> {

    @Getter
    @Setter
    private String mainInstrument;

    public Composer(String completeName, String mainInstrument) {

        super(completeName);

        this.mainInstrument = mainInstrument;
    }

    @Override
    public void perform(MusicPiece performable) {
        System.out.println(completeName + " is performing " + performable.getTitle());
    }

    public void perform(String workTitle) {
        perform(catalogue.get(workTitle));
    }
}
