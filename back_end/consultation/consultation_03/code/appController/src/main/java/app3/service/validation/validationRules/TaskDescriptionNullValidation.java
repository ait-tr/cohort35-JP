package app3.service.validation.validationRules;


import app3.dto.RequestDto;
import app3.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class TaskDescriptionNullValidation implements ValidationRule {
    @Override
    public void validate(RequestDto request) {
        if (request.getDescription() == null) {
            throw new ValidationException("Task description must be not null");
        }

    }
}
