package com.pablozoani.z_other_oop.z_trash.models.artist;

import lombok.Getter;
import lombok.Setter;

public class Writer extends Artist<Book> {

    @Getter
    @Setter
    private LiteraryGenre mainGenre;

    public Writer(String completeName) {
        super(completeName);
    }
}
