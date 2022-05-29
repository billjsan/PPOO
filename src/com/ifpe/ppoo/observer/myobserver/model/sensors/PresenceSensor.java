package com.ifpe.ppoo.observer.myobserver.model.sensors;

import com.ifpe.ppoo.observer.myobserver.model.Observer;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PresenceSensor implements Sensor {

    private String measureValue = "";
    private String currentMeasureResponse = "";
    private final List<Observer> observers = new ArrayList<>();
    private String sensorName;
    private String sensorAddress;
    private final int id;
    private static int _id = 0;

    public PresenceSensor(String name, String address) {
        this.sensorName = name;
        this.sensorAddress = address;
        this.id = _id;
        _id++;
    }

    public int getId() {
        return id;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorAddress() {
        return sensorAddress;
    }

    public void setSensorAddress(String address) {
        this.sensorAddress = address;
    }

    private String getMeasureResponse(){
      return  "Sensor: [" + getSensorName() + "] Measure: [" +
                measureValue + "]";
    }

    @Override
    public void measure() {
        measureValue = getMeasureSimulation();
        currentMeasureResponse = getMeasureResponse();
        onSensorMeasurementChanged();
    }

    @Override
    public void onSensorMeasurementChanged() {
        notifyObservers();
    }

    @Override
    public String getCurrentMeasurement() {
        return measureValue;
    }

    @Override
    public String getSensorInformation() {

        return getSensorName() + " " +
                getSensorAddress() + " id: " +
                getId();
    }

    @Override
    public void notifyObservers() {

        // use case: only notify when is true (alarm)
        if (measureValue.contains("false")) return;

        for (Observer obs : observers) {
            obs.onUpdate(PresenceSensor.this);
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

    private String getMeasureSimulation() {

        SecureRandom secureRandom = new SecureRandom();
        int value = secureRandom.nextInt(2);

        if (value == 0) {
            return "false";
        }
        return "true";
    }
}
