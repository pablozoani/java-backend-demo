package com.pablozoani.z_other_oop.z_trash.models.artist;

import lombok.Getter;
import lombok.Setter;

public class Picture extends Work {

    @Getter
    @Setter
    private Dimension2D dimension2D;

    public Picture(String title, double width, double height) {
        super(title);
        this.dimension2D = new Dimension2D(width, height);
    }

    public static class Dimension2D {

        private double width;

        private double height;

        public Dimension2D(double width, double height) {

            this.width = width;

            this.height = height;
        }
    }
}
