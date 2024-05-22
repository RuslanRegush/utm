package org.example;

import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    private List<Observer> observers = new ArrayList<>();
    private String newToy;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setNewToy(String newToy) {
        this.newToy = newToy;
        notifyAllObservers();
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public String getNewToy() {
        return newToy;
    }
}
