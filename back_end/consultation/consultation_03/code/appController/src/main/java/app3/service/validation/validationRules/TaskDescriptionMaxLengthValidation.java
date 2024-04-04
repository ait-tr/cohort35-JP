package app3.service.validation.validationRules;

import app3.dto.RequestDto;
import app3.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class TaskDescriptionMaxLengthValidation implements ValidationRule {
    @Override
    public void validate(RequestDto request) {
        if (request.getDescription().length() > 25) {
            throw new ValidationException("Task description length must be less than 25, but actual description length is " + request.getDescription().length());
        }

    }
}
