package br.com.zinid.returnal.application.config.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorOutput {

    private List<String> globalErrorMessages = new ArrayList<>();
    private List<FieldErrorOutput> fieldErrors = new ArrayList<>();

    public void addError(String message) {
        globalErrorMessages.add(message);
    }

    public void addFieldError(String field, String message) {
        FieldErrorOutput fieldError = new FieldErrorOutput(field, message);
        fieldErrors.add(fieldError);
    }

    public List<String> getGlobalErrorMessages() {
        return globalErrorMessages;
    }

    public List<FieldErrorOutput> getFieldErrors() {
        return fieldErrors;
    }

    public int getNumberOfErrors() {
        return fieldErrors.size();
    }
}
