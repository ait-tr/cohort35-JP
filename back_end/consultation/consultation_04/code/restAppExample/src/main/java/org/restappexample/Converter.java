package org.restappexample;

import org.springframework.stereotype.Service;

@Service
public class Converter {

    public User fromDtoToUser(UserDto userDto) {
        return new User(0, userDto.getFirstName(), userDto.getLastName(), userDto.getAge(), userDto.getEmail());
    }
}
