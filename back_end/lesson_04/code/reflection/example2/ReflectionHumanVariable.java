package lesson_04.code.reflection.example2;

import java.lang.reflect.Field;

public class ReflectionHumanVariable {
    public static void main(String[] args) throws IllegalAccessException {
        Human john = new Human("John", "London");

        System.out.println(john);

        Field[] fields = john.getClass().getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field);

            if (field.getName().equals("name")) {
                System.out.println("Private field 'name' was found!");
                field.setAccessible(true);
                field.set(john, "Bill");
            }
        }

        System.out.println(john);
    }
}
