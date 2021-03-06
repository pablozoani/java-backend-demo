package com.pablozoani.z_other_oop.z_trash.models.artist;

import lombok.Getter;
import lombok.Setter;

public abstract class Work {

    @Getter
    @Setter
    protected String title;

    @Getter
    @Setter
    protected String artistCompleteName;

    public Work(String title) {
        this.title = title;
    }
}
