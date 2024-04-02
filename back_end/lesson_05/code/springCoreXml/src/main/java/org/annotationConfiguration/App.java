package org.annotationConfiguration;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.annotationConfiguration");

        Cat cat = context.getBean(Cat.class);
        Dog dog = (Dog) context.getBean("dog");
        Parrot parrot = context.getBean("parrot-kesha", Parrot.class);

        System.out.println("========");

        System.out.println(cat.getName());
        System.out.println(dog.getName());
        System.out.println(parrot.getName());

        context.close();

    }
}
