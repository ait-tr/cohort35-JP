package code.app.service.validation.validationRules;

import code.app.service.validation.ValidationException;
import code.app.dto.RequestDto;

public class TaskNameMinLengthValidation implements ValidationRule{
    @Override
    public void validate(RequestDto request) {
        if (request.getName() == null) {
            throw new ValidationException("Task name length must be greater than 3, but actual name length is " + request.getName().length());
        }

    }
}
