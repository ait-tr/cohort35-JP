package lesson_01.code.part1;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from a thread");
    }
}
