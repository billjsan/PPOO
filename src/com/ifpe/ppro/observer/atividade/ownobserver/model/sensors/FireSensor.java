package com.ifpe.ppro.observer.atividade.ownobserver.model.sensors;

import com.ifpe.ppro.observer.atividade.ownobserver.model.Observer;

public class FireSensor implements Sensor{

    private String name;
    private String address;
    private int id;
    private static int _id = 0;


    public FireSensor(String name, String address) {
        this.name = name;
        this.address = address;
        id = _id;
        _id++;
    }

    @Override
    public void measure() {

        notifyObservers();
    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void unregisterObserver(Observer observer) {

    }

    @Override
    public void onSensorMeasurementChanged() {

    }

    @Override
    public String getCurrentMeasurement() {
        return null;
    }

    @Override
    public String getSensorInformation() {
        return null;
    }
}
