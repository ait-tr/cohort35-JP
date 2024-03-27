package lesson_03.code.ssot.service;

import lesson_03.code.ssot.repository.UserRepository;

public class FindUserService {

    private UserRepository repository;

    public FindUserService(UserRepository repository) {
        this.repository = repository;
    }

    public void findUserById(){
    }
}
