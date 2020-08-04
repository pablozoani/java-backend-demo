package com.pablozoani.zoop.z_trash.designpattern.decorator2;

public class IceCreamSuffixer extends IceCreamDecorator {

    public IceCreamSuffixer(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String makeIceCream() {
        return super.makeIceCream() + suffix();
    }

    private String suffix() {
        return " With Chocolate!";
    }
}
