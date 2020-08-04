package com.pablozoani.zoop.z_trash.designpattern.proxy;

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
