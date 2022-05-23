package com.ifpe.ppoo.observer.myobserver.model;

import com.ifpe.ppoo.observer.myobserver.model.sensors.Sensor;

public class Insurance implements Observer {
    @Override
    public void onUpdate(Observable observable) {

        if (observable instanceof Sensor sensor) {
            if (sensor.getCurrentMeasurement().contains("true")) {

                System.out.println("[Insurance] alert!, info: " +
                        sensor.getSensorInformation());
            }
        }
    }
}
