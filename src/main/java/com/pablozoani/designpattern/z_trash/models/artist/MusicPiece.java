package com.pablozoani.designpattern.z_trash.models.artist;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

public class MusicPiece extends Work implements Performable {

    @Getter @Setter
    private Duration duration;

    public MusicPiece(String title, int durationMinutes, int durationSeconds) {

        super(title);

        this.duration = Duration.ofMinutes(durationMinutes).plusSeconds(durationSeconds);
    }
}
