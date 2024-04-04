package app3.service.validation.validationRules;

import app3.dto.RequestDto;
import app3.service.validation.ValidationException;

public class TaskDescriptionMaxLengthValidation implements ValidationRule {
    @Override
    public void validate(RequestDto request) {
        if (request.getDescription() == null) {
            throw new ValidationException("Task description length must be less than 25, but actual name length is " + request.getName().length());
        }

    }
}
