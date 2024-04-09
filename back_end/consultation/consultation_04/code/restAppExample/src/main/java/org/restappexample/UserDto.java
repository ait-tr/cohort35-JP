package org.restappexample;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
}
