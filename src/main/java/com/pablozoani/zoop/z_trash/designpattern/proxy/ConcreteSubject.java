package com.pablozoani.zoop.z_trash.designpattern.proxy;

public class ConcreteSubject extends Subject {

    @Override
    public void doSomeWork() {
        System.out.println("Concrete subject is doing work...");
    }
}
