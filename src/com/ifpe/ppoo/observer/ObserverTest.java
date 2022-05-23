package com.ifpe.ppoo.observer;

import com.ifpe.ppoo.observer.myobserver.enviroment.TaskManager;
import com.ifpe.ppoo.observer.myobserver.enviroment.TaskWrapper;
import com.ifpe.ppoo.observer.myobserver.model.AlarmCentral;
import com.ifpe.ppoo.observer.myobserver.model.Insurance;
import com.ifpe.ppoo.observer.myobserver.model.Police;
import com.ifpe.ppoo.observer.myobserver.model.sensors.FireSensor;
import com.ifpe.ppoo.observer.myobserver.model.sensors.PresenceSensor;

import java.util.TimerTask;

public class ObserverTest {

    /**
     * tests if the timer task schedule is working properly
     */
    public static void onwObserverTimerTest(){


    }

    public static void ownObserverApp(){
        /**
         * configuration
         */
        AlarmCentral homeAlarmCenter = new AlarmCentral("sensor", "nowhere .st");

        FireSensor bathFireRoomSensor = new FireSensor("bathroom", "my home");
        FireSensor kitchenSensor = new FireSensor("kitchen", "my home");
        PresenceSensor porchPresenceSensor = new PresenceSensor("porch", "my home");

        porchPresenceSensor.registerObserver(homeAlarmCenter);
        bathFireRoomSensor.registerObserver(homeAlarmCenter);
        kitchenSensor.registerObserver(homeAlarmCenter);

        Police police = new Police();
        Insurance insurance = new Insurance();

        homeAlarmCenter.registerObserver(police);
        homeAlarmCenter.registerObserver(insurance);

        /**
         * executing simulation of real sensor measurement
         */
        TaskManager taskManager = TaskManager.getInstance();

        //presence porch sensor
        TaskWrapper porchPresenceSensorRoutineWrapper = new TaskWrapper();

        porchPresenceSensorRoutineWrapper.setSensor(porchPresenceSensor);
        porchPresenceSensorRoutineWrapper.setPeriodMillisecond(TaskWrapper.TASK_PERIOD_DEFAULT);
        porchPresenceSensorRoutineWrapper.setTask(new TimerTask() {
            @Override
            public void run() {
                porchPresenceSensor.measure();
            }
        });

        //bathroom fire sensor routine
        TaskWrapper bathroomFireMeasurementRoutineWrapper = new TaskWrapper();
        bathroomFireMeasurementRoutineWrapper.setSensor(bathFireRoomSensor);
        bathroomFireMeasurementRoutineWrapper.setPeriodMillisecond(TaskWrapper.TASK_PERIOD_RANDOM); // 5 sec
        bathroomFireMeasurementRoutineWrapper.setTask(new TimerTask() {
            @Override
            public void run() {
                bathFireRoomSensor.measure();
            }
        });

        taskManager.addTaskWrapper(porchPresenceSensorRoutineWrapper);
        taskManager.addTaskWrapper(bathroomFireMeasurementRoutineWrapper);
        taskManager.executeAllTasks();

    }


}
