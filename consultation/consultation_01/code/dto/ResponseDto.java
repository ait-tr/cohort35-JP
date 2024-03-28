package code.dto;

import java.util.List;

public class ResponseDto<T> {
    private T result;
    private List<String> errors;

    public ResponseDto(T result, List<String> errors) {
        this.result = result;
        this.errors = errors;
    }

    public T getResult() {
        return result;
    }

    public List<String> getErrors() {
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
