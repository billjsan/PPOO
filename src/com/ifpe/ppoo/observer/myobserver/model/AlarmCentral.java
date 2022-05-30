package com.ifpe.ppoo.observer.myobserver.model;

import com.ifpe.ppoo.observer.myobserver.enviroment.TaskManager;
import com.ifpe.ppoo.observer.myobserver.enviroment.TaskWrapper;
import com.ifpe.ppoo.observer.myobserver.model.sensors.Sensor;
import debug.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class AlarmCentral implements Observable, Observer {

    private final String TAG;
    private final List<Observer> observers = new ArrayList<>();
    private final List<Sensor> sensors = new ArrayList<>();

    public AlarmCentral(String name) {
        TAG = AlarmCentral.class.getSimpleName() + " [" + name + "]";
        if (Log.ISLOGABLE) Log.d(TAG, "AlarmCentral instantiate");
    }

    public void addSensors(Sensor sensor) {
        if (Log.ISLOGABLE) Log.d(TAG, "addSensors");
        sensor.registerObserver(AlarmCentral.this);
        this.sensors.add(sensor);
    }

    @Override
    public void notifyObservers() {
        if (Log.ISLOGABLE) Log.d(TAG, "notifyObservers");
        for (Observer obs : observers) {
            obs.onUpdate(this);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        if (Log.ISLOGABLE) Log.d(TAG, "registerObserver");
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        if (Log.ISLOGABLE) Log.d(TAG, "unregisterObserver");
        observers.remove(observer);
    }

    /**
     * when any sensor changes his values they call
     * this method
     *
     * @param observable
     */
    @Override
    public void onUpdate(Observable observable) {
        if (Log.ISLOGABLE) Log.d(TAG, "onUpdate");
        notifyObservers();
    }

    public void start() {
        if (Log.ISLOGABLE) Log.d(TAG, "start");
        List<TaskWrapper> taskWrappers = new ArrayList<>();
        TaskManager taskManager = TaskManager.getInstance();

        for (Sensor s : sensors) {
            TaskWrapper tw = new TaskWrapper();
            tw.setSensor(s);
            tw.setPeriodMillisecond(TaskWrapper.TASK_PERIOD_RANDOM);
            tw.setTask(new TimerTask() {
                @Override
                public void run() {
                    s.measure();
                    if (Log.ISLOGABLE) Log.d(TAG, "on run() measurement: [" +
                            s.getCurrentMeasurement() + "]");
                }
            });
            taskWrappers.add(tw);
        }

        for (TaskWrapper t : taskWrappers) {
            taskManager.addTaskWrapper(t);
        }
        taskManager.executeAllTasks();
    }
}
