package com.pablozoani.designpattern.z_trash.models.artist;

import lombok.Getter;
import lombok.Setter;

public class Writer extends Artist<Book> {

    @Getter @Setter
    private LiteraryGenre mainGenre;

    public Writer(String completeName) {
        super(completeName);
    }
}
