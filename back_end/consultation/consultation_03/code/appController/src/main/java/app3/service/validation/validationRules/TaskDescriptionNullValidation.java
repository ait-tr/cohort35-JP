package service.validation.validationRules;

import dto.RequestDto;
import service.validation.ValidationException;

public class TaskDescriptionNullValidation implements ValidationRule {
    @Override
    public void validate(RequestDto request) {
        if (request.getDescription() == null) {
            throw new ValidationException("Task description must be not null");
        }

    }
}
