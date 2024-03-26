package lesson_02.code.concurrent.semaphore.semafore;

public class Producer implements Runnable{

    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            store.put();
        }
    }
}
