package com.ifpe.ppro.observer;

import com.ifpe.ppro.observer.atividade.ownobserver.enviroment.TaskManager;
import com.ifpe.ppro.observer.atividade.ownobserver.enviroment.TaskWrapper;
import com.ifpe.ppro.observer.atividade.ownobserver.model.*;
import com.ifpe.ppro.observer.atividade.ownobserver.model.sensors.PresenceSensor;
import com.ifpe.ppro.observer.atividade.ownobserver.model.sensors.Sensor;

import java.util.TimerTask;

public class ObserverTest {

    /**
     * tests if the timer task schedule is working properly
     */
    public static void onwObserverTimerTest(){


    }

    public static void ownObserverApp(){

        AlarmCentral alarmCentral = new AlarmCentral();

        /**
         * alarm central observers registration
         */
        alarmCentral.registerObserver(new Police());
        alarmCentral.registerObserver(new Insurance());

        /**
         * sensors instantiation
         */
        Sensor presenceSensor_01 = new PresenceSensor("presenceSensor_01","Rua das estradas, n 800");
        Sensor presenceSensor_02 = new PresenceSensor("presenceSensor_02","Rua das perolas, n 150");
        Sensor presenceSensor_03 = new PresenceSensor("presenceSensor_03","Rua nova, n 800");

        /**
         * sensor observers registration
         */
        presenceSensor_01.registerObserver(alarmCentral);
        presenceSensor_02.registerObserver(alarmCentral);
        presenceSensor_03.registerObserver(alarmCentral);


        /**
         * simulate the sensors measurement
         */
        TaskManager taskManager = TaskManager.getInstance();

        //task 1
        TaskWrapper taskWrapper1 = new TaskWrapper();
        taskWrapper1.setPeriod(3000);
        taskWrapper1.setSensor(presenceSensor_01);
        taskWrapper1.setTask(new TimerTask() {
            @Override
            public void run() {
                presenceSensor_01.measure();
            }
        });

        //task 2
        TaskWrapper taskWrapper2 = new TaskWrapper();
        taskWrapper2.setSensor(presenceSensor_02);
        taskWrapper2.setPeriod(1500);
        taskWrapper2.setTask(new TimerTask() {
            @Override
            public void run() {
                presenceSensor_02.measure();
            }
        });

        taskManager.addTaskWrapper(taskWrapper1);
        taskManager.addTaskWrapper(taskWrapper2);

        taskManager.executeTasks();

    }


}
