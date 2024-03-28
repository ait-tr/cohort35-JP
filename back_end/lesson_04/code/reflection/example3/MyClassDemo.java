package lesson_04.code.reflection.example3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MyClass myClass = new MyClass();
        int number = myClass.getNumber();
        String name = null;

        System.out.println(number + name); // 0null

        try {
            Field field = myClass.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(myClass);
            field.set(myClass, (String) "new value");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println(number + name); //0default

        Method method = myClass.getClass().getDeclaredMethod("printData");
        method.setAccessible(true);
        method.invoke(myClass);



    }
}
