public class MultipleInterfaceVariants {
    // {CompileTimeError} (не компилируются)

    interface Payable<T> {}

    class Employee implements Payable<Employee> {}
//    class Hourly extends Employee implements Payable<Hourly> {}
}
