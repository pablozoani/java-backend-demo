package com.pablozoani.z_other_oop.z_trash.designpattern.observer;

public class User implements Observer {

    private final String name;

    private Subject subject;

    private String currentArticle;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update() {

        currentArticle = (String) subject.getUpdate();

        System.out.println("User " + "\u001B[36m" + name +
                "\u001B[0m" + " is reading the new article " + currentArticle + "!");
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
