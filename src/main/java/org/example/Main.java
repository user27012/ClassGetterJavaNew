import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main<T> {
    private List<T> data;

    public Main() {
        data = new ArrayList<>();
    }

    public void addElement(T value) {
        data.add(value);
    }

    public T getElement(int index) {
        if (index >= 0 && index < data.size()) {
            return data.get(index);
        } else {
            throw new IndexOutOfBoundsException("Такого индекса не наблюдается..");
        }
    }

    public int getCount() {
        return data.size();
    }

    public static void printClassInfo(Class<?> clazz) {
        System.out.println("Інформація про клас: " + clazz.getName());

        // Вивести поля класу
        System.out.println("Поля класу:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Назва поля: " + field.getName() + ", Тип: " + field.getType());
        }

        // Вивести методи класу
        System.out.println("Методи класу:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Назва методу: " + method.getName() + ", Параметри: " + method.getParameterTypes());
        }
    }

    public static void main(String[] args) {
        Class<?> myClass = Main.class;
        printClassInfo(myClass);
    }
}
