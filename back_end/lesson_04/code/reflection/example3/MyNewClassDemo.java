package lesson_04.code.reflection.example3;

public class MyNewClassDemo {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        System.out.println(myClass);

//=======================================

        try {

            Class clazz = Class.forName(myClass.getClass().getName());
            myClass = (MyClass) clazz.newInstance();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println(myClass);
    }
}
