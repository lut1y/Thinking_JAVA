package controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 05.11.2019.
 */
// Вместе с классом Event составляет систему
// управления общего характера:

public class Controller {
    // Класс пакета java.util для хранения объектов Event
    private List<Event> eventList = new ArrayList<Event>();

    public void addEvent(Event c) { eventList.add(c); }
    public void run() {
        while(eventList.size() > 0)
            // Создать копию, чтобы избежать модификации списка
            // во время выборки элементов:
            for(Event e : new ArrayList<Event>(eventList))
                if(e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
    }
}
