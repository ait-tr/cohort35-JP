package app3.service.validation.validationRules;


import app3.dto.RequestDto;
import app3.service.validation.ValidationException;

public class TaskNameNullValidation implements ValidationRule {
    @Override
    public void validate(RequestDto request) {
        if (request.getName() == null) {
            throw new ValidationException("Task name must be not null");
        }

    }
}
