package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 123 on 05.11.2019.
 */
// Вместе с классом Event составляет систему
// управления общего характера:

public class Controller {
    // Класс пакета java.util для хранения объектов Event
    private LinkedList<Event> eventList = new LinkedList<Event>();

    public void addEvent(Event c) { eventList.add(c); }
    public void run() {
        Event e;
        /*
        * while(eventList.size() > 0)
        // Создать копию, чтобы избежать модификации списка
        // во время выборки элементов:

        * for(Event e : new LinkedList<Event>(eventList))
        *    if(e.ready()) {
        *        System.out.println(e);
        *        e.action();
        *        eventList.remove(e);
        *    }
        */
        while (eventList.size() > 0) {
            Iterator<Event> iterator = eventList.iterator();
            e = iterator.next();
            if(e.ready()) {
                System.out.println(e);
                e.action();
                eventList.removeFirst();
            }
        }
    }
}
