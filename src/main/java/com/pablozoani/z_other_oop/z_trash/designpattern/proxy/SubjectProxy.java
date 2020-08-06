package com.pablozoani.z_other_oop.z_trash.designpattern.proxy;

public class SubjectProxy extends Subject {

    private static Subject cs;

    @Override
    public void doSomeWork() {

        System.out.println("Proxy method started!");

        if (cs == null) cs = new ConcreteSubject();

        cs.doSomeWork();

        System.out.println("Proxy method finished!");
    }
}
