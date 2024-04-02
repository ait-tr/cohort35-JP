package code.app.service.validation.validationRules;

import code.app.dto.RequestDto;

public interface ValidationRule {
    void validate(RequestDto request);
}
