package lesson_02.code.concurrent.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionExample2 {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 100;
        int numberOfElements = 1000;

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        List<Thread> concurrentList = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(() -> {
                addToCopeOnWriteList(copyOnWriteArrayList, numberOfElements);
            });
            concurrentList.add(thread);
        }

        long startTime = System.currentTimeMillis();
        for (Thread thread : concurrentList) {
            thread.start();
            thread.join();
        }


        long endTime = System.currentTimeMillis();

        long concurrentLinkedQueueTime = endTime - startTime;

        System.out.println("Time cuncurrent array list = " + concurrentLinkedQueueTime);


    }

    private static void addToCopeOnWriteList(CopyOnWriteArrayList copyOnWriteArrayList, int numberOfElements) {
        for (int i = 0; i < numberOfElements; i++) {
            copyOnWriteArrayList.add(i);
        }
    }
}
