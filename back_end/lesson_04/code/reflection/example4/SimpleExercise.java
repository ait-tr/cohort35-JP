package lesson_04.code.reflection.example4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SimpleExercise {

    /*
    1) создать новый объект
    2) получить имя конструктора
    3) получить публичные методы класса
    4) создать объект из метода2 и запустить его
    5) создать объект из поля str и заменить его на "группа 35"
    6) создать объекты из метода1 и метода3 и запустить их
     */

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        Simple simple = new Simple();

        // создаем новый объект Класс из нашего объекта simple
        Class cls = simple.getClass();
        System.out.println("имя класса: " + cls.getName());

        // получаем имя конструктора
        Constructor constructor = cls.getConstructor();
        System.out.println("Имя конструктора: " + constructor.getName());

        // получаем публичные методы
        Method[] methods = cls.getMethods();

        for (Method method : methods) {
            System.out.println(method);
        }

        // создаем объект нужного метода и параметра класса
        Method methodCall2 = cls.getDeclaredMethod("method2",int.class);
        methodCall2.invoke(simple,25);


        // создаем объект поля с помощью имени поля

        Field field = cls.getDeclaredField("str");
        field.setAccessible(true);
        field.set(simple,"группа 35");

        Method methodCall1 = cls.getDeclaredMethod("method1");
        methodCall1.invoke(simple);


        Method methodCall3 = cls.getDeclaredMethod("method3");
        methodCall3.setAccessible(true);
        methodCall3.invoke(simple);

    }


}
