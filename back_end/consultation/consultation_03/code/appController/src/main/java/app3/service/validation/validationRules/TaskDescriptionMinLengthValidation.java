package app3.service.validation.validationRules;


import app3.dto.RequestDto;
import app3.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class TaskDescriptionMinLengthValidation implements ValidationRule {
    @Override
    public void validate(RequestDto request) {
        if (request.getDescription().length() < 3) {
            throw new ValidationException("Task description length must be greater than 3, but actual description length is " + request.getDescription().length());
        }

    }
}
