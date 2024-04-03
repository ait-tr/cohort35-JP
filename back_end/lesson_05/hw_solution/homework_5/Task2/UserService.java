package homework.homework_5.Task2;

import homework.homework_5.Task2.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void greetUser() {
        System.out.println("Hello, " + userRepository.getUserName());
    }
}
