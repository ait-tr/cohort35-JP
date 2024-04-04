package service.validation.validationRules;

import dto.RequestDto;
import service.validation.ValidationException;

public class TaskNameMaxLengthValidation implements ValidationRule {
    @Override
    public void validate(RequestDto request) {
        if (request.getName() == null) {
            throw new ValidationException("Task name length must be less than 15, but actual name length is " + request.getName().length());
        }

    }
}
