package com.ifpe.ppoo.observer.myobserver.model;

import com.ifpe.ppoo.observer.myobserver.model.sensors.Sensor;
import debug.Log;

public class Insurance implements Observer {

    private final String TAG = Insurance.class.getSimpleName();

    @Override
    public void onUpdate(Observable observable) {
        if (Log.ISLOGABLE) Log.d(TAG, "onUpdate");
        if (observable instanceof Sensor sensor) {
            if (sensor.getCurrentMeasurement().contains("true")) {
                if (Log.ISLOGABLE) Log.d(TAG, "Alert the house was invaded!!! sensor info [" +
                        ((Sensor) observable).getSensorInformation() + "]");
            }
        }
    }
}
