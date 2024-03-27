package lesson_03.code.ssot.repository;

import lesson_03.code.ssot.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private Integer userId = 0;
    private List<User> users = new ArrayList<>();

    public void addUser(User newUser){

        userId++;
        users.add(newUser);

    }

    public Integer getUserId() {
        return userId;
    }
}
