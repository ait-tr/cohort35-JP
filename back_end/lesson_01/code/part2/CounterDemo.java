package lesson_01.code.part2;

public class CounterDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new CounterThread(counter));
        Thread thread2 = new Thread(new CounterThread(counter));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {}

        System.out.println("Counter : " + counter.getCount());

    }
}
