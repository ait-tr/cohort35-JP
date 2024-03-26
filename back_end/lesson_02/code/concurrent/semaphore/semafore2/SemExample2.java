package lesson_02.code.concurrent.semaphore.semafore2;

import java.util.concurrent.Semaphore;

public class SemExample2 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Buyer(semaphore, "Поток № " + i));
            thread.start();
        }
    }

    static class Buyer implements Runnable {
        private Semaphore semaphore;
        private String name;

        public Buyer(Semaphore semaphore, String name) {
            this.semaphore = semaphore;
            this.name = name;
        }


        @Override
        public void run() {
            try {
                System.out.println(name + " ждет в очереди на вход в магазин");
                semaphore.acquire();
                System.out.println(name + " зашел в магазин");
                // какой-то код - что покупатель делает в магазине
                Thread.sleep(1000);
                System.out.println(name + " совершил покупки и вышел из магазина");
                semaphore.release();
            } catch (InterruptedException e) {}
        }
    }
}
