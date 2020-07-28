package com.pablozoani.designpattern.z_trash.models.house;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dimensions {

    private double length;

    private double width;

    private double height;

    public Dimensions(double length, double width, double height) {

        this.length = length;

        this.width = width;

        this.height = height;
    }

    @Override
    public String toString() {
        return "length: " + length + ", width: " + width + ", height: " + height;
    }
}
