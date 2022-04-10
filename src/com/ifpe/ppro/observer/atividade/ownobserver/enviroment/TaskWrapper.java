package com.ifpe.ppro.observer.atividade.ownobserver.enviroment;

import java.util.TimerTask;

public class TaskWrapper {

    public static final int TASK_PERIOD_DEFAULT = 1000;
    public static final int TASK_PERIOD_RANDOM = -1;

    private TimerMeasurementTask sensor;
    private TimerTask task;
    private int period;

    public TaskWrapper() {
    }

    public TimerMeasurementTask getSensor() {
        return sensor;
    }

    public void setSensor(TimerMeasurementTask sensor) {
        this.sensor = sensor;
    }

    public TimerTask getTask() {
        return task;
    }

    public void setTask(TimerTask task) {
        this.task = task;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
