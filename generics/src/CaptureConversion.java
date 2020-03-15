public class CaptureConversion {
    static <T> void f1(Holder <T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }
    static void f2(Holder<?> holder) {
        f1(holder); // Вызов с зафиксированным типом
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        f1(raw); // Выдает предупреждения
        f2(raw);
        Holder rawBasic = new Holder();
        rawBasic.set(new Object()); // Предупреждение
        f2(rawBasic); // Без предупреждений
        // Восходящее преобразование к Holder<?>
        // тип все равно определяется правильно:
        Holder<?> wildcarded = new Holder<Double>(1.0);
        f2(wildcarded);

    }
}
