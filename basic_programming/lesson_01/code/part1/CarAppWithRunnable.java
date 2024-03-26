package lesson_01.code.part1;

public class CarAppWithRunnable {
    public static void main(String[] args) {
        var ferrari = new Car("Ferrari");
        var bmw = new Car("BMW");

        var ferrariThread = new Thread(ferrari, "Ferrari-Thread");
        var bmwThread = new Thread(bmw, "BMW-Thread");

        var ferrariThread2 = new Thread(ferrari, "Ferrari-Thread2");

        ferrariThread.start();
        bmwThread.start();
        ferrariThread2.start();

        System.out.println("Method continue execution... Main method is executed by thread " + Thread.currentThread().getName());
    }
}
