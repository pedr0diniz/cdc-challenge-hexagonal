package br.com.zinid.returnal.config.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        ValidationErrorOutput validationErrors = buildValidationErrors(globalErrors, fieldErrors);

        Problem problem = new Problem(
                status.value(),
                "One or more field values are invalid. Fill them correctly and try again",
                validationErrors);

        return handleExceptionInternal(ex, problem, headers, HttpStatus.BAD_REQUEST, request);
    }

    public ValidationErrorOutput buildValidationErrors(
            List<ObjectError> globalErrors, List<FieldError> fieldErrors) {

        ValidationErrorOutput validationErrors = new ValidationErrorOutput();

        globalErrors.forEach(error -> validationErrors.addError(error.getDefaultMessage()));
        fieldErrors.forEach(error -> validationErrors.addFieldError(error.getField(), error.getDefaultMessage()));

        return validationErrors;
    }
}
