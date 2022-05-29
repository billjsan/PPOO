package com.ifpe.ppoo.observer.myobserver.enviroment;

import debug.Log;

import java.util.Random;
import java.util.TimerTask;

/**
 * this is a wrapper class that encapsulate a task to used
 * in TaskManager. This contains all information to
 * perform the task as such the Task, the sensor and the time
 * needed to perform the action.
 */
public class TaskWrapper {

    private final String TAG;

    public static final int TASK_PERIOD_DEFAULT = -2;
    public static final int TASK_PERIOD_RANDOM = -1;

    private TimerMeasurementTask sensor;
    private TimerTask task;
    private int period;

    private static int _wrapperId = 1;

    public TaskWrapper() {
        int id = _wrapperId;
        _wrapperId++;
        TAG = TaskWrapper.class.getSimpleName() + " [" + id + "]";
        if(Log.ISLOGABLE) Log.d(TAG, "TaskWrapper instantiate");
    }

    public TimerMeasurementTask getSensor() {
        if(Log.ISLOGABLE) Log.d(TAG, "getSensor");
        return sensor;
    }

    public void setSensor(TimerMeasurementTask sensor) {
        if(Log.ISLOGABLE) Log.d(TAG, "setSensor");
        this.sensor = sensor;
    }

    public TimerTask getTask() {
        if(Log.ISLOGABLE) Log.d(TAG, "getTask");
        return task;
    }

    public void setTask(TimerTask task) {
        if(Log.ISLOGABLE) Log.d(TAG, "setTask");
        this.task = task;
    }

    public int getPeriod() {
        if(Log.ISLOGABLE) Log.d(TAG, "getPeriod");
        return period;
    }

    /**
     * this method receive an integer who is the
     * time in milliseconds that the task must
     * wait before perform the action after being
     * scheduled
     * @param period
     */
    public void setPeriodMillisecond(int period) {

        int TASK_PERIOD_TIME = 1000;
        if(period == TASK_PERIOD_DEFAULT){
            this.period = TASK_PERIOD_TIME;
        } else if (period == TASK_PERIOD_RANDOM) {
            Random random = new Random();
            this.period = 1 + random.nextInt(50000);
        }else {
            if(period <= 0){
                this.period = TASK_PERIOD_TIME;
            }else {
                this.period = period;
            }
        }
        if(Log.ISLOGABLE) Log.d(TAG, "setPeriodMillisecond [" + this.period + " period]");
    }
}
