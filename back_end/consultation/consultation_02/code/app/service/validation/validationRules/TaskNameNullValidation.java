package code.app.service.validation.validationRules;

import code.app.service.validation.ValidationException;
import code.app.dto.RequestDto;

public class TaskNameNullValidation implements ValidationRule{
    @Override
    public void validate(RequestDto request) {
        if (request.getName() == null) {
            throw new ValidationException("Task name must be not null");
        }

    }
}
