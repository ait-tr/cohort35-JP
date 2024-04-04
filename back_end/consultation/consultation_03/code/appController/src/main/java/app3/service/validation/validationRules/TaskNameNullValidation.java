package service.validation.validationRules;

import dto.RequestDto;
import service.validation.ValidationException;

public class TaskNameNullValidation implements ValidationRule {
    @Override
    public void validate(RequestDto request) {
        if (request.getName() == null) {
            throw new ValidationException("Task name must be not null");
        }

    }
}
