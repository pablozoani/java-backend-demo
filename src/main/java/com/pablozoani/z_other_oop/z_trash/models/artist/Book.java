package com.pablozoani.z_other_oop.z_trash.models.artist;

import lombok.Getter;
import lombok.Setter;

public class Book extends Work {

    @Getter
    @Setter
    private LiteraryGenre genre;

    public Book(String title, LiteraryGenre genre) {

        super(title);

        this.genre = genre;
    }
}
