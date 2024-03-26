package lesson_01.code.part1;

public class ThreadExample1 extends Thread{
    @Override
    public void run(){
        System.out.println("I'm Thread! My name is " + getName());
    }
}
