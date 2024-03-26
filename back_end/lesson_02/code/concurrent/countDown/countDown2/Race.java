package lesson_02.code.concurrent.countDown.countDown2;

import java.util.concurrent.CountDownLatch;

public class Race {
    private static final CountDownLatch START = new CountDownLatch(8);

    private static final int trackLength = 500000;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(new Car(i, (int) (Math.random()*100 + 50))).start();
            Thread.sleep(1000);
        }

        while (START.getCount() > 3) {
            Thread.sleep(100); }

        System.out.println("На старт");
         START.countDown();
        System.out.println("Внимание!");
        START.countDown();
        Thread.sleep(1000);
        System.out.println("Марш!");
        START.countDown();

    }

    public static class Car implements Runnable {
        private int carNumber;
        private int carSpeed;

        public Car(int carNumber, int carSpeed) {
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
        }

        @Override
        public void run() {
            try{
                System.out.printf(" Автомобиль №%d подъехал к стартовой линии \n",carNumber);
                START.countDown();
                START.await();
                Thread.sleep(trackLength / carSpeed);
                System.out.printf(" Автомобиль №%d финишировал \n",carNumber);

            } catch (InterruptedException e) {}
        }
    }
}
