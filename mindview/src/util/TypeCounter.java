package util;

import java.util.HashMap;
import java.util.Map;

// Подсчет экземпляров семейства типов.
public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;  // Поле для типа
    // Конструктор, сохраняющий тип в baseType
    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }
    // метод count, который получает тип класса объекта
    // и проверяет соответствие типа с базовым типом baseType
    // и подсчитывает его
    public void count(Object obj) {
        Class<?> type = obj.getClass();
        if(!baseType.isAssignableFrom(type))
            throw new RuntimeException(obj + " неправильный тип: "
            + type + ", должен быть подтипом "
            + baseType);
        countClass(type);
    }
    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        // т.к. расширяем HashMap, то соотв-но объект HashMap не создаем
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        // проверяем принадлежность к иерархии подсчитываем иерархию
        if(superClass != null &&
                baseType.isAssignableFrom(superClass))
            countClass(superClass);
    }
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for(Map.Entry<Class<?>, Integer> pair : entrySet()) {
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(", ");
        }
        result.delete(result.length()-2, result.length());
        result.append("}");
        return result.toString();
    }
}
