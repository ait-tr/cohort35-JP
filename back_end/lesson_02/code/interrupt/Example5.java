package lesson_02.code.interrupt;

public class Example5 implements Runnable{

    private boolean stop;

    @Override
    public void run() {
    while (!stop) {
        System.out.println("Thread id running!");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.out.println("Interrupted!");
            //stop = true;
            return;
        }
        }
    }

    public void stopThread() {
        stop = true;
    }


    public static void main(String[] args) throws InterruptedException {


        Example5 ie = new Example5();

        Thread thread = new Thread(ie);
        thread.start();
        Thread.sleep(5000);
        //ie.stopThread(); - вариант номер 1
        thread.interrupt();
    }


}
