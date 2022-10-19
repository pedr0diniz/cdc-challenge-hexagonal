package br.com.zinid.returnal.config.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem {

    private final Integer status;
    private final OffsetDateTime dateTime = OffsetDateTime.now();
    private final String title;
    private ValidationErrorOutput fields;

    public Integer getStatus() {
        return status;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public String getTitle() {
        return title;
    }

    public ValidationErrorOutput getFields() {
        return fields;
    }

    public Problem(Integer status, String title, ValidationErrorOutput fields) {
        this.status = status;
        this.title = title;
        this.fields = fields;
    }

    public Problem(Integer status, String title) {
        this.status = status;
        this.title = title;
    }
}
