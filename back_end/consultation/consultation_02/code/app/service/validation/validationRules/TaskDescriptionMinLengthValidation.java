package code.app.service.validation.validationRules;

import code.app.dto.RequestDto;
import code.app.service.validation.ValidationException;

public class TaskDescriptionMinLengthValidation implements ValidationRule {
    @Override
    public void validate(RequestDto request) {
        if (request.getDescription() == null) {
            throw new ValidationException("Task description length must be greater than 3, but actual name length is " + request.getName().length());
        }

    }
}
