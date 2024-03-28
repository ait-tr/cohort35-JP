package lesson_04.code.reflection.example4;

public class Simple {
    private String str;

    public Simple() {
        this.str = "Java Reflection API";
    }

    public void method1() {
        System.out.println("Information from variable: " + str);
    }

    public void method2(int x) {
        System.out.println("целое число: " + x);
    }

    private void method3() {
        System.out.println("вызов приватного метода");
    }
}
