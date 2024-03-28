package lesson_04.code.annotation.example2;

public class MarkedDemo {
    public static void main(String[] args) {
        MarkedClass marked = new MarkedClass();
        NonMarkedClass nonMarked = new NonMarkedClass();

        test(marked);
        //test(nonMarked);

    }

    static void test(MyMark markedObj){
        System.out.println("Тест успешно пройден");
    }
}
