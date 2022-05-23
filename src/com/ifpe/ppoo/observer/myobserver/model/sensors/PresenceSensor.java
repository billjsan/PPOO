package com.ifpe.ppoo.observer.myobserver.model.sensors;

import com.ifpe.ppoo.observer.myobserver.model.Observer;
import com.ifpe.ppoo.observer.myobserver.model.util.Util;

import java.util.ArrayList;
import java.util.List;

public class PresenceSensor implements Sensor {
    private String currentMeasure = "";
    private String currentMeasureResponse = "";
    private final List<Observer> observers = new ArrayList<>();
    private String name;
    private String address;
    private final int id;
    private static int _id = 0;

    public PresenceSensor(String name, String address) {
        this.name = name;
        this.address = address;
        this.id = _id;
        _id++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void measure() {
        Util.setTimePattern(Util.TIME_SEPARATOR_COMMA);
        Util.setDatePattern(Util.DATE_SEPARATOR_ASH);

        currentMeasure = Util.measurePresenceSimulate();
        currentMeasureResponse = "Sensor: " + getName() + " " +
                currentMeasure + " " +
                Util.formattedDateAndTime();
        onSensorMeasurementChanged();
    }

    @Override
    public void onSensorMeasurementChanged() {
        System.out.println(currentMeasureResponse);
        notifyObservers();
    }

    @Override
    public String getCurrentMeasurement() {
        return currentMeasure;
    }

    @Override
    public String getSensorInformation() {

        return getName() + " " +
                getAddress() + " id: " +
                getId();
    }

    @Override
    public void notifyObservers() {

        if (currentMeasure.contains("false")) return;
        System.out.println("[" + getName() + "]: Presence sensor set to [On] Notifying observes ");
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
}
