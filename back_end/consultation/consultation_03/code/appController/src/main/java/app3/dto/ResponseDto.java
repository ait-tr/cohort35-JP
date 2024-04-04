package dto;

import service.validation.validationRules.CoreError;

import java.util.List;

public class ResponseDto<T> {
    private T result;
    private List<CoreError> errors;

    public ResponseDto(T result, List<CoreError> errors) {
        this.result = result;
        this.errors = errors;
    }

    public T getResult() {
        return result;
    }

    public List<CoreError> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "result=" + result +
                ", errors=" + errors +
                '}';
    }
}
