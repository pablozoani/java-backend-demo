package com.pablozoani.z_other_oop.z_trash.designpattern.proxy;

public class ConcreteSubject extends Subject {

    @Override
    public void doSomeWork() {
        System.out.println("Concrete subject is doing work...");
    }
}
