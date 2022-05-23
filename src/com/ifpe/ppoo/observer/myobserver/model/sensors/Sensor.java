package com.ifpe.ppoo.observer.myobserver.model.sensors;

import com.ifpe.ppoo.observer.myobserver.enviroment.TimerMeasurementTask;
import com.ifpe.ppoo.observer.myobserver.model.Observable;

public interface Sensor extends Observable, TimerMeasurementTask {

    void onSensorMeasurementChanged();

    String getCurrentMeasurement();

    String getSensorInformation();
}
