package com.pablozoani.webapp.layers.model.base;

public enum FieldOfStudy {

    MATHEMATICS("Mathematics"), COMPUTER_SCIENCE("Computer Science"),
    STATISTICS("Statistics"), CHEMISTRY("Chemistry"), PHYSICS("Physics");

    private String name;

    FieldOfStudy(String name) { this.name = name; }

    @Override
    public String toString() { return name; }
}
