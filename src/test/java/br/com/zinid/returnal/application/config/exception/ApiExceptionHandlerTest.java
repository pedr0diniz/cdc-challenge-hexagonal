package br.com.zinid.returnal.application.config.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ApiExceptionHandlerTest {

    @InjectMocks
    private ApiExceptionHandler handler;

    @Test
    void buildValidationErrorsWithOnlyGlobalErrors() {
        // given
        ObjectError globalError = org.mockito.Mockito.mock(ObjectError.class);
        given(globalError.getDefaultMessage()).willReturn("State is mandatory");

        // when
        ValidationErrorOutput result = handler.buildValidationErrors(List.of(globalError), List.of());

        // then
        assertThat(result.getGlobalErrorMessages()).containsExactly("State is mandatory");
        assertThat(result.getFieldErrors()).isEmpty();
    }

    @Test
    void buildValidationErrorsWithOnlyFieldErrors() {
        // given
        FieldError fieldError = org.mockito.Mockito.mock(FieldError.class);
        given(fieldError.getField()).willReturn("email");
        given(fieldError.getDefaultMessage()).willReturn("must be a valid email");

        // when
        ValidationErrorOutput result = handler.buildValidationErrors(List.of(), List.of(fieldError));

        // then
        assertThat(result.getGlobalErrorMessages()).isEmpty();
        assertThat(result.getFieldErrors()).hasSize(1);
        assertThat(result.getFieldErrors().get(0).getField()).isEqualTo("email");
        assertThat(result.getFieldErrors().get(0).getMessage()).isEqualTo("must be a valid email");
    }

    @Test
    void buildValidationErrorsWithBothGlobalAndFieldErrors() {
        // given
        ObjectError globalError = org.mockito.Mockito.mock(ObjectError.class);
        FieldError fieldError = org.mockito.Mockito.mock(FieldError.class);
        given(globalError.getDefaultMessage()).willReturn("State is mandatory");
        given(fieldError.getField()).willReturn("name");
        given(fieldError.getDefaultMessage()).willReturn("must not be blank");

        // when
        ValidationErrorOutput result = handler.buildValidationErrors(List.of(globalError), List.of(fieldError));

        // then
        assertThat(result.getGlobalErrorMessages()).containsExactly("State is mandatory");
        assertThat(result.getFieldErrors()).hasSize(1);
        assertThat(result.getNumberOfErrors()).isEqualTo(1);
    }

    @Test
    void buildValidationErrorsWithEmptyLists() {
        // given / when
        ValidationErrorOutput result = handler.buildValidationErrors(List.of(), List.of());

        // then
        assertThat(result.getGlobalErrorMessages()).isEmpty();
        assertThat(result.getFieldErrors()).isEmpty();
    }
}
