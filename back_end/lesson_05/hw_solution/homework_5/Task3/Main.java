package homework.homework_5.Task3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TimePrinter timePrinter = context.getBean(TimePrinter.class);
        timePrinter.printCurrentTime();
        context.close();
    }
}
