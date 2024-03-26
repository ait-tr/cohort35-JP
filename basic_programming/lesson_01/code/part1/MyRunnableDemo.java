package lesson_01.code.part1;

public class MyRunnableDemo{
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
