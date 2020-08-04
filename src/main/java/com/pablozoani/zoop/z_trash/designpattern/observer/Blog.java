package com.pablozoani.zoop.z_trash.designpattern.observer;

import javax.validation.constraints.NotNull;
import java.util.*;

public class Blog implements Subject {

    private List<Observer> observers = new ArrayList<>();

    private Deque<String> articles = new LinkedList<>();

    public Blog() {

    }

    @Override
    public void registerObserver(@NotNull Observer observer) {

        observers.add(observer);

        observer.setSubject(this);
    }

    @Override
    public void unregisterObserver(@NotNull Observer observer) {

        observers.remove(observer);

        observer.setSubject(null);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) observer.update();
    }

    @Override
    public Object getUpdate() {
        return articles.getLast();
    }

    public void postNewArticle(String article) {

        articles.addLast(article);

        notifyObserver();
    }
}
