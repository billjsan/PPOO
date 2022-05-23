package com.ifpe.ppoo.observer.myobserver.model;

import java.util.ArrayList;
import java.util.List;

public class AlarmCentral implements Observable, Observer {

    private final List<Observer> observers = new ArrayList<>();
    private String temperatureSensor;
    private double humiditySensor;
    private boolean presentSensor;
    private String address = "Rua carolina, 55";
    private String id;


    private AlarmCentral(){

    }

    public AlarmCentral(String id, String address) {
        this.id = id;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private final List<String> presentMeasurementHistory = new ArrayList<>();

    public String getAddress() {

        return address;
    }

    public void setTemperatureSensorMeasurement(String temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
        notifyObservers();
    }

    public void setHumiditySensor(double humiditySensor) {
        this.humiditySensor = humiditySensor;
        notifyObservers();
    }

    public void setPresentSensor(boolean presentSensor) {
        this.presentSensor = presentSensor;
        notifyObservers();
    }

    public void setAddress(String address) {
        this.address = address;
        notifyObservers();
    }

    public String getTemperatureSensor() {
        return temperatureSensor;
    }

    public double getHumiditySensor() {
        return humiditySensor;
    }

    public boolean isPresentSensor() {
        return presentSensor;
    }

    @Override
    public void notifyObservers() {

        for (Observer obs : observers) {
            obs.onUpdate(this);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {

        observers.remove(observer);
    }

    /**
     * when any sensor changes his values they call
     * this method
     *
     * @param observable
     */
    @Override
    public void onUpdate(Observable observable) {

        System.out.println("[Alarm Central] onUpdate ");
        notifyObservers();
    }
}