package com.pablozoani.zoop.z_trash.designpattern.decorator2;

public abstract class IceCreamDecorator implements IceCream {

    protected IceCream iceCream;

    public IceCreamDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String makeIceCream() {
        return iceCream.makeIceCream();
    }
}
