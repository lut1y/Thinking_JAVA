package controller;

/**
 * Created by 123 on 05.11.2019.
 */
// Общие для всякого управляющего события методы.

public abstract class Event {
    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }
    public void start() { // с возможностью перезапуска
        eventTime = System.nanoTime() + delayTime;
    }
    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }
    public abstract void action();

    //public long showEventTime() {return eventTime;}
}


