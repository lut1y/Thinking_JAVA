// изучение смысла масок.
public class Wildcards {
    // Неспециализированный аргумент:
    static void rawArgs(Holder holder, Object arg) {  // N.: обобщенный тип и специализированный тип
//        holder.set(arg); // Предупреждение:
//        Неконтролируемый вызов set(T) как члена
//        holder.set(new Wildcards());  // То же предупреждение

//        Невозможно - 'T' отсутствует:
//        T t = holder.get();

//        Допустимо, но информация типа теряется:
        Object obj = holder.get();
    }
    // Аналогично rawArgs(), но с выдачей ошибок вместо предупреждений:
    static void unboundedArg(Holder<?> holder, Object arg) {
        // holder.set(arg); // Ошибка:
        // set(capture of ?) в Holder<capture of ?>
        // не может применяться к (Object)
        // holder.set(new Wildcards()); // Та же ошибка

        // Невозможно - 'T' отсутствует:
        // T t = holder.get();

        // Допустимо, но информация типа теряется:
        Object obj = holder.get();
    }
    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }
    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }
    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        // holder.set(arg); // Ошибка:
        // set(capture of ? extends T) в
        // Holder<capture of ? extends T>
        // не может применяться к (T)
        T t = holder.get();
        return t;
    }
    static <T> void wildSupertype(Holder <? super T> holder, T arg) {
        holder.set(arg);
        // T t = holder.get();  // Ошибка:
        // Несовместимые типы: обнаружен Object, требуется T

        // Допустимо, но информация типа теряется:
        Object obj = holder.get();
    }
    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        // Или:
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        // Object r1 = exact1(raw); // Предупреждение:
        // Неконтролируемое преобразование Holder в Holder<T>
        // Неконтролируемый вызов метода: exact1(Holder<T>)
        // применяется к (Holder)
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);

        // Long r5 = exact2(raw, lng);  // Предупреждения:
        // Неконтролируемое преобразование Holder в Holder<Long>
        // Неконтролируемый вызов метода: exact2(Holder<T>, T)
        // применяется к (Holder, Long)
        Long r6 = exact2(qualified, lng);
        // Long r7 = exact2(unbounded, lng); // Ошибка:
        // exact2(Holder<T>, T) не может применяться
        // к (Holder<capture of ?>, Long)
        // Long8 = exact2(bounded, lng);  // Ошибка:
        // exact2(Holder<T>, T) не может применяться
        // к (Holder<T>, T) не может применяться

        // Long r9 = wildSubtype(raw, lng); // Предупреждения:
        // Неконтролируемое преобразование Holder
        // в Holder<? super Long>
        // Неконтролируемый вызов метода:
        // wildSupertype(Holder<? super T>, T)
        // применяется к (Holder, Long)
        Long r10 = wildSubtype(qualified, lng);
        // Доступно, но может возвращать только Object:
        Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);

        // wildSupertype(raw, lng); // Предупреждения:
        // Неконтролируемое преобразование Holder
        // в Holder<? super Long>
        // Неконтролируемый вызов метода:
        // wildSupertype(Holder<? super T>, T)
        // применяется к (Holder, Long)
        wildSupertype(qualified, lng);
        // wildSupertype(undouned, lng);  // Ошибка:
        // wildSupertype(Holder<? super T>, T);  // не может
        // применяться к (Holder<capture of ?>, Long)
        // wildSupertype(bounded, lng); // Ошибка:
        // wildSupertype(Holder<? super T>, T) не может
        // применяться к (Holder<capture of ? extends Long>, Long)
    }
}
