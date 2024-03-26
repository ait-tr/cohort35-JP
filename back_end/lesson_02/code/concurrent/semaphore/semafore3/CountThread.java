package lesson_02.code.concurrent.semaphore.semafore3;

import java.util.concurrent.Semaphore;

public class CountThread implements Runnable{
    CommonResources resources;
    Semaphore semaphore;
    String name;

    public CountThread(CommonResources resources, Semaphore semaphore, String name) {
        this.resources = resources;
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " ожидает разрешение");
            semaphore.acquire();
            resources.x = 1;

            for (int i = 0; i < 10; i++) {
                System.out.println(name + ": " + resources.x);
                resources.x++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {}

        System.out.println(name + " освобождает полученное разрешение");
        semaphore.release();
    }
}
