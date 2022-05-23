package com.ifpe.ppoo.observer.myobserver.model;

public interface Observable {

    void notifyObservers();

    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);
}
