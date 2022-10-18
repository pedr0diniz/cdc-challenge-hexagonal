package br.com.zinid.returnal.exception;

public class FieldErrorOutput {

    private String field;
    private String message;

    public FieldErrorOutput(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
