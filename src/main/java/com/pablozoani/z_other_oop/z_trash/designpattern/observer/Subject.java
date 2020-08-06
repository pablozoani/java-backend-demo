package com.pablozoani.z_other_oop.z_trash.designpattern.observer;

public interface Subject {

    void registerObserver(Observer observer);

    void notifyObserver();

    void unregisterObserver(Observer observer);

    Object getUpdate();
}
