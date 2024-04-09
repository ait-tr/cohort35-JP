package org.restappexample;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    // localhost:8080/users?firstName=John

    @GetMapping("/findByName")
    public List<User> findByName(@RequestParam(value = "firstName") String firstName) {
        return userService.findByFirstName(firstName);
    }

    // localhost:8080/users?email=email1@email.com
    @GetMapping("/findByEmail")
    public User findByEmail(@RequestParam(value = "email") String email) {
        return userService.findByEmail(email);
    }

    @PostMapping
    public User addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }
}
