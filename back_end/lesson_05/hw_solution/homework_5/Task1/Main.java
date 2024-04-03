package homework.homework_5.Task1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MessageService messageService = context.getBean("messageService", MessageService.class);
        messageService.printMessage();
        context.close();
    }
}