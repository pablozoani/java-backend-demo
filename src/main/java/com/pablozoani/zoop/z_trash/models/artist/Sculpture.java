package com.pablozoani.zoop.z_trash.models.artist;

import lombok.Getter;
import lombok.Setter;

public class Sculpture extends Work {

    @Getter @Setter
    private Dimension3D dimension3D;

    public Sculpture(String title, double width, double height, double length) {
        this(title, new Dimension3D(width, height, length));
    }

    public Sculpture(String title, Dimension3D dimension3D) {

        super(title);

        this.dimension3D = dimension3D;
    }

    @Getter
    @Setter
    public static class Dimension3D {

        double width;

        double height;

        double length;

        public Dimension3D(double width, double height, double length) {

            this.width = width;

            this.height = height;

            this.length = length;
        }
    }
}
