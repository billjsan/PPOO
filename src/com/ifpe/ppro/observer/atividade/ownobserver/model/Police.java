package com.ifpe.ppro.observer.atividade.ownobserver.model;

import com.ifpe.ppro.observer.atividade.ownobserver.model.sensors.Sensor;

public class Police implements Observer {
    @Override
    public void onUpdate(Observable observable) {

        if (observable instanceof Sensor sensor) {
            if (sensor.getCurrentMeasurement().contains("true")) {

                System.out.println("[Police] sound alarm, info: " +
                        sensor.getSensorInformation());
            }
        }

    }
}
