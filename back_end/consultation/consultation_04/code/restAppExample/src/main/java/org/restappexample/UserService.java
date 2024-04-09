package org.restappexample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final Converter converter;

    public User addUser(UserDto userDto) {
        User newUser = repository.save(converter.fromDtoToUser(userDto));
        return newUser;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public List<User> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    public User findById(Integer id) {
        Optional<User> userSearchResult = repository.findById(id);
        if (userSearchResult.isPresent()) {
            return userSearchResult.get();
        } else {
            throw new IllegalStateException("Bad request");
        }
    }

    public User findByEmail(String email) {
        Optional<User> userSearchResult = repository.findByEmail(email);
        if (userSearchResult.isPresent()) {
            return userSearchResult.get();
        } else {
            throw new IllegalStateException("Bad request");
        }
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
