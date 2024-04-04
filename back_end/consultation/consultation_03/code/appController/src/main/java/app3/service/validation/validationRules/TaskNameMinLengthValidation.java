package app3.service.validation.validationRules;


import app3.dto.RequestDto;
import app3.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class TaskNameMinLengthValidation implements ValidationRule {
    @Override
    public void validate(RequestDto request) {
        if (request.getName() == null) {
            throw new ValidationException("Task name length must be greater than 3, but actual name length is " + request.getName().length());
        }

    }
}
