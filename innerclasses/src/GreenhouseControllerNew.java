import controller.Event;
import controller.GreenhouseControls;

/**
 * Created by 123 on 05.11.2019.
 */
// настройка и запуск системы управления

public class GreenhouseControllerNew extends GreenhouseController {
    private boolean provetrivanie = false;
    public class ProvetrOff extends Event {


        public ProvetrOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            provetrivanie = false;
        }

        public String toString() {return "Проветривание оранжереи выключено";}
    }
    public class ProvetrOn extends Event {


        public ProvetrOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            provetrivanie = false;
        }

        public String toString() {return "Проветривание оранжереи включено";}
    }

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        GreenhouseControllerNew gcn = new GreenhouseControllerNew();
        // Вместо жесткой фиксации параметров в коде
        // можно было бы считать информацию
        // из текстового файла:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gcn.new ProvetrOff(1000),
                gcn.new ProvetrOn(1200),
                gc.new ThermostatDay(1800)
        };
        gc.addEvent(gc.new Restart(2400, eventList));
        if(args.length == 1)
            gc.addEvent(new GreenhouseControls.Terminate(
                    new Integer(5400)));
        gc.run();
    }
}
