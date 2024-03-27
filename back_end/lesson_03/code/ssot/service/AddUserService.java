package lesson_03.code.ssot.service;

import lesson_03.code.ssot.entity.User;
import lesson_03.code.ssot.repository.UserRepository;

import java.util.Scanner;

public class AddUserService {

    private Integer userId = 0;
    private UserRepository repository;

    public AddUserService(UserRepository repository) {
        this.repository = repository;
    }

    public void addNewUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter user name: ");
        String name = scanner.nextLine();
        int userId = repository.getUserId();
        repository.addUser(new User(userId, name));

        scanner.close();
    }
}
