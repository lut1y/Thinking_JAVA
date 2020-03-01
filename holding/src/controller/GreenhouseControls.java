package controller;

/**
 * Created by 123 on 05.11.2019.
 */

// Пример конкретного приложения на основе системы
// управления, все находится в одном классе. Внутренние
// классы дают возможность инкапсулировать различную
// функциональность для каждого отдельного события.

public class GreenhouseControls extends Controller {
    private boolean light = false;

    public class LightOn extends Event {
        // конструктор
        public LightOn(long delayTime) { super(delayTime); }
        // методы
        public void action() {
            // Поместите сюда код управления оборудованием,
            // выполняющий непосредственное включение света.
            light = true;
        }
        public String toString() { return "Свет включен"; }
    }
    public class LightOff extends Event {
        // конструктор
        public LightOff(long delayTime) { super(delayTime); }
        // методы
        public void action() { light = false; }
        public String toString() { return "Свет выключен"; }
    }

    private boolean water = false;
    public class WaterOn extends Event {
        // конструктор
        public WaterOn(long delayTime) { super(delayTime); }
        // методы
        public void action() { water = true; }
        public String toString() { return "Полив включен"; }
    }
    public class WaterOff extends Event {
        // конструктор
        public WaterOff(long delayTime) { super(delayTime); }
        // методы
        public void action() { water = false; }
        public String toString() { return "Полив выключен"; }
    }

//    private boolean provetrivanie = false;
//    public class ProvetrOn extends Event {
//         конструктор
//        public ProvetrOn(long delayTime) { super(delayTime); }
//         методы
//        public void action() {
//             Поместите сюда код управления оборудованием,
//             выполняющий непосредственное включение проветривания оранжереи.
//            light = true;
//        }
//        public String toString() { return "Проветривание оранжереи включено"; }
//    }
//    public class ProvetrOff extends Event {
//         конструктор
//        public ProvetrOff(long delayTime) { super(delayTime); }
//         методы
//        public void action() { light = false; }
//        public String toString() { return "Проветривание оранжереи выключено"; }
//    }

    private String termostat = "День";
    public class ThermostatNight extends Event {
        // конструктор
        public ThermostatNight(long delayTime) { super(delayTime); }
        // методы
        public void action() {
            // Здесь размещается код управления оборудованием
            termostat = "Ночь"; }
        public String toString() {
            return "Термостат использует ночной режим";
        }
    }
    public class ThermostatDay extends Event {
        // конструктор
        public ThermostatDay(long delayTime) { super(delayTime); }
        // методы
        public void action() {
            // Здесь размещается код управления оборудованием
            termostat = "День"; }
        public String toString() {
            return "Термостат использует дневной режим";
        }
    }
    // Пример метода action(), вставляющего новый экзмепляр
    // самого себя в список событий:
    public class Bell extends Event {
        public Bell(long delayTime) { super(delayTime);}
        public void action() { new Bell(delayTime);}
        public String toString() { return "Бам!"; }
    }
    public class Restart extends Event {
        private Event[] eventList;
        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for(Event e : eventList)
                addEvent(e);
        }
        public void action() {
            for(Event e : eventList) {
                e.start(); // Перезапуск каждого события
                addEvent(e);
            }
            start(); // Перезапуск текущего события
            addEvent(this);
        }
        public String toString() { return "Перезапуск системы"; }
    }
    public static class Terminate extends Event {
        public Terminate(long delayTime) { super(delayTime); }
        public void action() {System.exit(0); }
        public String toString() { return "Отключение"; }
    }
}
