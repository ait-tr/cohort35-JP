package code.app.service.validation;

import code.app.dto.RequestDto;
import code.app.service.validation.validationRules.CoreError;
import code.app.service.validation.validationRules.ValidationRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ValidationService {

    private final List<ValidationRule> validationRules;

    public ValidationService(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CoreError> validate(RequestDto request){
        List<CoreError> errors = new ArrayList<>();

        if (request == null) {
            errors.add(new CoreError("Task request must be not null"));
            return errors;
        }

        return validationRules.stream()
                .map(rule -> validate(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError validate(ValidationRule rule, RequestDto request){
        try {
            rule.validate(request);
        } catch (ValidationException e){
            return new CoreError(e.getMessage());
        }

        return null;
    }

}
