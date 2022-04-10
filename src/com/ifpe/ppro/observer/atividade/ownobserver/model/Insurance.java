package com.ifpe.ppro.observer.atividade.ownobserver.model;

import com.ifpe.ppro.observer.atividade.ownobserver.model.sensors.Sensor;

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
