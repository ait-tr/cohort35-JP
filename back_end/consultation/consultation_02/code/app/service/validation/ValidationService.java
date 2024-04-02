package code.app.service.validation;

import code.app.dto.RequestDto;

import java.util.ArrayList;
import java.util.List;

public class ValidationService {

    public List<String> validate(RequestDto requestDto){
        List<String> errors = new ArrayList<>();

        if (requestDto.getName() == null) {errors.add("Task name must be not null");}
        if (requestDto.getName().length() < 3) {errors.add("Task name length must be greater than 3, but actual name length is " + requestDto.getName().length());}
        if (requestDto.getName().length() > 15) {errors.add("Task name length must be less than 15, but actual name length is " + requestDto.getName().length());}
        if (requestDto.getDescription().length() < 3) {errors.add("Task description length must be greater than 3, but actual description length is " + requestDto.getDescription().length());}
        if (requestDto.getDescription().length() > 25) {errors.add("Task description length must be less than 25, but actual description length is " + requestDto.getDescription().length());}

        return errors;

    }

}
