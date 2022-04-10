package com.ifpe.ppro.observer.atividade.ownobserver.model.sensors;

import com.ifpe.ppro.observer.atividade.ownobserver.enviroment.TimerMeasurementTask;
import com.ifpe.ppro.observer.atividade.ownobserver.model.Observable;

public interface Sensor extends Observable, TimerMeasurementTask {

    void onSensorMeasurementChanged();

    String getCurrentMeasurement();

    String getSensorInformation();
}
