package lesson_04.code.annotation.annotation3;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

@HelloAnnotation(value = "Hello", greetTo = "Universe")
public class GreetingAnnotation {
    public static void main(String[] args) {
        GreetingAnnotation demo = new GreetingAnnotation();

        Class gaClass = demo.getClass();
        Annotation[] annotations = gaClass.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        for (Annotation annotation : annotations) {
            System.out.println("Annotation type: " + annotation.annotationType());
        }

            HelloAnnotation myAnnotation = (HelloAnnotation) gaClass.getAnnotation(HelloAnnotation.class);
            System.out.println("Value = " + myAnnotation.value());
            System.out.println("GreetTo = " + myAnnotation.greetTo());

        try {
            Method m = gaClass.getMethod("sayHi");
            myAnnotation = m.getAnnotation(HelloAnnotation.class);
            System.out.println("Value = " + myAnnotation.value());
            System.out.println("GreetTo = " + myAnnotation.greetTo());

        } catch (NoSuchMethodException e) {}

        demo.sayHello();

    }

    @HelloAnnotation(value = "Hello", greetTo = "Alice")
    public void sayHi(){
    }

    @HelloAnnotation(value = "Hello", greetTo = "Robert")
    public void sayHello(){
        try {
            Method method = getClass().getMethod("sayHello");
            HelloAnnotation annotation = method.getAnnotation(HelloAnnotation.class);

            System.out.println(annotation.value() + " " + annotation.greetTo());
        } catch (NoSuchMethodException e) {}
    }

}
