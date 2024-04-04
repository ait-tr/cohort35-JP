package service.validation.validationRules;

import dto.RequestDto;
import service.validation.ValidationException;

public class TaskNameMinLengthValidation implements ValidationRule {
    @Override
    public void validate(RequestDto request) {
        if (request.getName() == null) {
            throw new ValidationException("Task name length must be greater than 3, but actual name length is " + request.getName().length());
        }

    }
}
