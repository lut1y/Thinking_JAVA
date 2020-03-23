public class Task31 {
    interface Playable { float getPay(); }

    class Employee implements Playable {
        private float weeklyPay;
        public float getPay() {
            return weeklyPay;
        }
    }

    class Hourly extends Employee {
        public String name;
        protected float hourlyPay;
        public int hoursWorked;

        public Hourly(String name, float hourlyPay, int hoursWorked) {
            this.name = name;
            this.hourlyPay = hourlyPay;
            this.hoursWorked = hoursWorked;
        }
        public float getPay() {
            System.out.printf("Pay %s $%6.2f\n", name, hourlyPay*hoursWorked);
            return hourlyPay*hoursWorked;
        }
    }
    public static void main(String[] args) {
        Task31 t31 = new Task31();
        Hourly h = t31. new Hourly("Joe", 50.00f, 40);
        h.getPay();
    }
}
