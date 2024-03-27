package lesson_03.code.dip;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PersonApp {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepositoryImpl();

        PersonService service = new PersonService(repository);

        List<String> list = new LinkedList<>();
        listInfo(list);

    }

    public static void listInfo(List<String> list) {}
}
