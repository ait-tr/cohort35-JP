package lesson_03.code.dip;

public class PersonService {

    PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public void addNewPerson() {
        repository.addPerson(new Person());
    }
}
