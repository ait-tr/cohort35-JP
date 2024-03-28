package lesson_04.code.reflection.example3;

public class MyClass {
    private int number;
    private String name = "default";

//    public MyClass(int number, String name) {
//        this.number = number;
//        this.name = name;
//    }


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
}
