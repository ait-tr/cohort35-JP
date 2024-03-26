package lesson_02.code.interrupt;

import java.util.concurrent.TimeUnit;

public class Example4 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        Runnable task = () -> {

            while (!Thread.currentThread().isInterrupted()) {
                // ======== do something =========
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                    Thread.currentThread().interrupt();
                } catch (Exception e){}
                //=================
                }
            System.out.println("Thread finished ...");
        };


        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(10000);
        thread.interrupt();
        System.out.println("Main thread is finished ...");

    }
}
