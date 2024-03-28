package lesson_04.code.reflection.example3;

public class MyClass2 {
    private int number;
    private String name = "default";

    public MyClass2(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public MyClass2() {}

    public MyClass2(int number) {
        this.number = number;
    }

    public MyClass2(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private void printData() {
        System.out.println(number + name);
    }

    @Override
    public String toString() {
        return "MyClass2{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
