package com.ifpe.ppoo.observer;

import com.ifpe.ppoo.observer.myobserver.model.AlarmCentral;
import com.ifpe.ppoo.observer.myobserver.model.Insurance;
import com.ifpe.ppoo.observer.myobserver.model.Police;
import com.ifpe.ppoo.observer.myobserver.model.sensors.PresenceSensor;

public class ObserverTest {
    public static void ownObserverApp(){
        AlarmCentral alarmCentral = new AlarmCentral("Central do will");

        alarmCentral.addSensors(new PresenceSensor("1", "porch"));
        alarmCentral.addSensors(new PresenceSensor("2", "kitchen"));
        alarmCentral.addSensors(new PresenceSensor("3", "garage"));
        alarmCentral.addSensors(new PresenceSensor("4", "backs"));

        alarmCentral.registerObserver(new Police());
        alarmCentral.registerObserver(new Insurance());

        alarmCentral.start();
    }
}
