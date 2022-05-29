package com.ifpe.ppoo.observer.myobserver.model.sensors;

import com.ifpe.ppoo.observer.myobserver.model.Observer;
import debug.Log;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PresenceSensor implements Sensor {

    private final String TAG;
    private String measureValue = "";
    private final List<Observer> observers = new ArrayList<>();
    private String sensorName;
    private String sensorAddress;
    private final int id;
    private static int _id = 0;

    public PresenceSensor(String name, String address) {
        this.sensorName = name;
        this.sensorAddress = address;
        this.id = _id;
        this.TAG = PresenceSensor.class.getSimpleName() + " [" + getId() + "]";
        _id++;
        if(Log.ISLOGABLE) Log.d(TAG,"PresenceSensor instantiate");
    }

    public int getId() {
        if(Log.ISLOGABLE) Log.d(TAG,"getId [" + this.id + "]");
        return id;
    }

    public String getSensorName() {
        if(Log.ISLOGABLE) Log.d(TAG,"getSensorName [" + this.sensorName + "]");
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        if(Log.ISLOGABLE) Log.d(TAG,"getSensorName [" + sensorName + "]");
        this.sensorName = sensorName;
    }

    public String getSensorAddress() {
        if(Log.ISLOGABLE) Log.d(TAG,"getSensorAddress [" + this.sensorAddress + "]");
        return sensorAddress;
    }

    public void setSensorAddress(String address) {
        if(Log.ISLOGABLE) Log.d(TAG,"setSensorAddress [" + address + "]");
        this.sensorAddress = address;
    }

    private String getMeasureResponse(){
        if(Log.ISLOGABLE) Log.d(TAG,"getMeasureResponse");
      return  "Sensor: [" + getSensorName() + "] Measure: [" +
                measureValue + "]";
    }

    @Override
    public void measure() {
        if(Log.ISLOGABLE) Log.d(TAG,"measure");
        measureValue = getMeasureSimulation();
        String currentMeasureResponse = getMeasureResponse();
        onSensorMeasurementChanged();
    }

    @Override
    public void onSensorMeasurementChanged() {
        if(Log.ISLOGABLE) Log.d(TAG,"onSensorMeasurementChanged");
        notifyObservers();
    }

    @Override
    public String getCurrentMeasurement() {
        if(Log.ISLOGABLE) Log.d(TAG,"getCurrentMeasurement");
        return measureValue;
    }

    @Override
    public String getSensorInformation() {
        if(Log.ISLOGABLE) Log.d(TAG,"getSensorInformation");
        return getSensorName() + " " +
                getSensorAddress() + " id: " +
                getId();
    }

    @Override
    public void notifyObservers() {
        if(Log.ISLOGABLE) Log.d(TAG,"notifyObservers");
        // use case: only notify when is true (alarm)
        if (measureValue.contains("false")) return;

        for (Observer obs : observers) {
            obs.onUpdate(PresenceSensor.this);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        if(Log.ISLOGABLE) Log.d(TAG,"registerObserver");
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        if(Log.ISLOGABLE) Log.d(TAG,"unregisterObserver");
        observers.remove(observer);
    }

    private String getMeasureSimulation() {
        if(Log.ISLOGABLE) Log.d(TAG,"getMeasureSimulation");

        SecureRandom secureRandom = new SecureRandom();
        int value = secureRandom.nextInt(2);

        if (value == 0) {
            return "false";
        }
        return "true";
    }
}
