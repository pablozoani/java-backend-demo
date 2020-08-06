package com.pablozoani.webapp.layers.business.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() { super("It was not found"); }

    public NotFoundException(String message) { super(message); }
}
