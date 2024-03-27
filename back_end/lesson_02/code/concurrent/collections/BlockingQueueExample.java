package lesson_02.code.concurrent.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        // создадим блокирующую очередь с лимитом в 3 элемента
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        // создаем и запускаем производителя товара

        Thread producer = new Thread(() -> {
         try {
             for (int i = 1; i <= 5 ; i++) {
                 System.out.println("Producer добавляет товар: " + i);
                 queue.put(i);
                 Thread.sleep(1000);
             }
         }  catch (InterruptedException e) {}
        }
        );

        producer.start();

        // Создаем и запускаем покупателя

        Thread consumer = new Thread(() -> {
            int counter = 0;
            try {
                while (counter < 5) {
                    Integer element = queue.take();
                    System.out.println("Consumer покупает товар: " + element);
                    Thread.sleep(2000);
                    counter++;
                }
            }  catch (InterruptedException e) {}
        }
        );
        consumer.start();


    }
}
