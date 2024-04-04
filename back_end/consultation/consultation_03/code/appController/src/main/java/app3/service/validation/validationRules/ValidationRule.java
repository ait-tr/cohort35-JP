package service.validation.validationRules;

import dto.RequestDto;

public interface ValidationRule {
    void validate(RequestDto request);
}
