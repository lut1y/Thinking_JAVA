public class Holder<T> {
    private T value;
    public Holder() {}
    public Holder(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        return value.equals(o);
    }

    public static void main(String[] args) {
        Holder<Apple> Apple = new Holder<Apple>(new Apple());
        Apple d = Apple.get();
        Apple.set(d);
//        Holder<Fruit> Fruit = Apple; // Восходящее преобразование не выполняется
        Holder<? extends Fruit> fruit = Apple;
        Fruit p = fruit.get();
        d = (Apple) fruit.get();
        try {
            Orange c = (Orange) fruit.get();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.printf("fruit.equals(d): %b\n", fruit.equals(d));
    }

}
