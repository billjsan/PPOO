package com.ifpe.ppoo.observer.myobserver.enviroment;

import debug.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * this class is used to manage the TimerTasks
 */
public class TaskManager {
    private final String TAG = TaskManager.class.getSimpleName();

    private static TaskManager instance;
    private final List<TaskWrapper> tasks = new ArrayList<>();

    private TaskManager() {
        if(Log.ISLOGABLE) Log.d(TAG, "TaskManager instantiate");
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addTaskWrapper(TaskWrapper taskWrapper) {
        if(Log.ISLOGABLE) Log.d(TAG, "addTaskWrapper");
        tasks.add(taskWrapper);
    }

    public void removeTask(TaskWrapper taskWrapper) {
        if(Log.ISLOGABLE) Log.d(TAG, "removeTask");
        tasks.remove(taskWrapper);
    }

    public void executeAllTasks() {
        if(Log.ISLOGABLE) Log.d(TAG, "executeAllTasks [" + tasks.size() + " tasks]");
        Timer timer = new Timer();

        for (TaskWrapper tw : tasks) {
            timer.schedule(tw.getTask(), 0, tw.getPeriod());
        }
    }
}
