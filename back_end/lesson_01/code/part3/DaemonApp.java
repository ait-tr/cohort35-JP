package lesson_01.code.part3;

public class DaemonApp {
    public static void main(String[] args) {
        var worker = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            var threadName = Thread.currentThread().getName();
            System.out.println("Thread name " + threadName + " is executing!");
        }, "Worker");

        var daemon = new Thread(() -> {
            int count = 0;
            while (count < 10) {
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("прервали");
                }
                var threadName = Thread.currentThread().getName();
                System.out.println("Thread name " + threadName + " is executing!");
            }
        }, "daemon");


        daemon.setDaemon(true);
        worker.start();
        daemon.start();
    }
}
