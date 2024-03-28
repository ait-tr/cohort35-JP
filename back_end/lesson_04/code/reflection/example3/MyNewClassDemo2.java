package lesson_04.code.reflection.example3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

public class MyNewClassDemo2 {
    public static void main(String[] args) {
        MyClass2 myClass2 = null;
//=======================================

        try {
            Class clazz = Class.forName(MyClass2.class.getName());
            Class[] params = {int.class, String.class};
            myClass2 = (MyClass2) clazz.getConstructor(params).newInstance(1,"new value");


            Constructor[] constructors = clazz.getConstructors();

            for (Constructor constructor : constructors) {
                Class[] paramTypes = constructor.getParameterTypes();
                for (Class paramType : paramTypes) {
                    System.out.print(paramType.getName() + ", " );
                }
                System.out.println();
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        System.out.println(myClass2);


    }
}
