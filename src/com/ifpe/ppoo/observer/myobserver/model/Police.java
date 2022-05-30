package com.ifpe.ppoo.observer.myobserver.model;

import com.ifpe.ppoo.observer.myobserver.model.sensors.Sensor;
import debug.Log;

public class Police implements Observer {

    private final String TAG = Police.class.getSimpleName();

    @Override
    public void onUpdate(Observable observable) {
        if (Log.ISLOGABLE) Log.d(TAG, "onUpdate ? " + observable.getClass().getSimpleName());
        if (observable instanceof Sensor sensor) {
            if (sensor.getCurrentMeasurement().contains("true")) {
                if (Log.ISLOGABLE) Log.d(TAG, "Alert the house was invaded!!! sensor info [" +
                        ((Sensor) observable).getSensorInformation() + "]");
            }
        }
    }
}
