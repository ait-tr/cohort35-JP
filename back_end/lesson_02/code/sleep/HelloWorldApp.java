package lesson_02.code.sleep;

public class HelloWorldApp {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                int secWait = 20 * 1000;
                Thread.currentThread().sleep(secWait);
                System.out.println("Wake up!");

                // TimeUnit.sleep(10);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}
