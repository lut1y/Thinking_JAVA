public class ArrayOfGenericType<T> {
    T[] array;
    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
//        array = new T[size];
        array = (T[]) new Object[size];
    }
//    public <U> U[] makeArray() { return new U[10]; }
}
