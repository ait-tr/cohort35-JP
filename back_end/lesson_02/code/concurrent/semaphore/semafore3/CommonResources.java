package lesson_02.code.concurrent.semaphore.semafore3;

public class CommonResources {
    int x = 0;
}

/*
написать приложение которое запускает три потока
установим семафор с лимитом в 2 потока
каждый поток в цикле 0 до 10 менять общий ресурс ++

 */
