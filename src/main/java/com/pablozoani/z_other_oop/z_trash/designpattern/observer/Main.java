package com.pablozoani.z_other_oop.z_trash.designpattern.observer;

public class Main {

    public static void main(String[] args) {

        Blog universeBlog = new Blog();

        User loisLane = new User("lois1");

        User peterParker = new User("peter_parker");

        User bruceWayne = new User("bWayne");

        universeBlog.registerObserver(peterParker);

        universeBlog.registerObserver(bruceWayne);

        universeBlog.postNewArticle("\u001B[35m" + "'First Black Hole Photo'" + "\u001B[0m");

        universeBlog.unregisterObserver(peterParker);

        universeBlog.registerObserver(loisLane);

        universeBlog.postNewArticle("\u001B[34m" + "'The First Operational Flight of the SpaceX Crew'" + "\u001B[0m");
    }
}
