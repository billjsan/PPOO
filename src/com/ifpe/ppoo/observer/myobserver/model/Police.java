package com.ifpe.ppoo.observer.myobserver.model;

import com.ifpe.ppoo.observer.myobserver.model.sensors.Sensor;

public class Police implements Observer {
    @Override
    public void onUpdate(Observable observable) {

        if(observable instanceof AlarmCentral central){
            System.out.println("[Police] sound alarm, info: " + central.getTemperatureSensor());
        }

        if (observable instanceof Sensor sensor) {
            if (sensor.getCurrentMeasurement().contains("true")) {

                System.out.println("[Police] sound alarm, info: " +
                        sensor.getSensorInformation());
            }
        }

    }
}
