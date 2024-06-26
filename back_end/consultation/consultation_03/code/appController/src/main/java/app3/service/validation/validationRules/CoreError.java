package app3.service.validation.validationRules;

import java.util.Objects;

public class CoreError {

    private String message;

    public CoreError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreError coreError = (CoreError) o;
        return Objects.equals(message, coreError.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(message);
    }

    @Override
    public String toString() {
        return "CoreError{" +
                "message='" + message + '\'' +
                '}';
    }
}
