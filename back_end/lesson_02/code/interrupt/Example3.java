package lesson_02.code.interrupt;

public class Example3 implements Runnable{

    private boolean stop;

    @Override
    public void run() {
    while (!stop) {
        System.out.println("Thread id running!");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {}
        }
    }

    public void stopThread() {
        stop = true;
    }


    public static void main(String[] args) throws InterruptedException {


        Example3 ie = new Example3();

        Thread thread = new Thread(ie);
        thread.start();
        Thread.sleep(5000);
        ie.stopThread();
    }


}
