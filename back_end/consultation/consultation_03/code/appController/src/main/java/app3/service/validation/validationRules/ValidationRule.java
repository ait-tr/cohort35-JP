package app3.service.validation.validationRules;

import app3.dto.RequestDto;

public interface ValidationRule {
    void validate(RequestDto request);
}
