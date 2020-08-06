package com.pablozoani.z_other_oop.z_trash.designpattern.decorator2;

public class IceCreamPrefixer extends IceCreamDecorator {

    public IceCreamPrefixer(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String makeIceCream() {
        return prefix() + super.makeIceCream();
    }

    private String prefix() {
        return "A Big ";
    }
}
