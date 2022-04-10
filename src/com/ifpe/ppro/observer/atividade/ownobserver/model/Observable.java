package com.ifpe.ppro.observer.atividade.ownobserver.model;

public interface Observable {

    void notifyObservers();

    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);
}
