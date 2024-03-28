package lesson_04.code.annotation.selfMadeAnnotation3;

public @interface Todo {

    String description() default "No description";

}
