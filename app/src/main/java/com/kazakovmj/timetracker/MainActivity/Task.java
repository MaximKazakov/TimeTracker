package com.kazakovmj.timetracker.MainActivity;

/**
 * Created by Макс on 15.03.2017.
 */

public class Task {
    private String name;
    private int seconds;
    private int doneSeconds;
    private boolean isRunning;

    public Task(String name, int seconds) {
        this.name = name;
        this.seconds = seconds;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getSeconds() {
        return seconds;
    }
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getDoneSeconds() {
        return doneSeconds;
    }
    public void setDoneSeconds(int doneSeconds) {
        this.doneSeconds = doneSeconds;
    }

    public boolean isRunning() {
        return isRunning;
    }
    public void setRunning(boolean running) {
        isRunning = running;
    }
}
