package com.ifpe.ppoo.observer.myobserver.enviroment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * this class is used to manage the TimerTasks
 */
public class TaskManager {

    private static TaskManager instance;
    private final List<TaskWrapper> tasks = new ArrayList<>();

    private TaskManager() {

    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addTaskWrapper(TaskWrapper taskWrapper) {
        tasks.add(taskWrapper);
    }

    public void removeTask(TaskWrapper taskWrapper) {
        tasks.remove(taskWrapper);
    }

    public void executeAllTasks() {
        Timer timer = new Timer();

        for (TaskWrapper tw : tasks) {
            timer.schedule(tw.getTask(), 0, tw.getPeriod());
        }
    }
}
