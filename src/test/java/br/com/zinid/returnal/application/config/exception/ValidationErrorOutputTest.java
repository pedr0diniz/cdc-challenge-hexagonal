package br.com.zinid.returnal.application.config.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationErrorOutputTest {

    @Test
    void startsWithNoErrors() {
        // given / when
        ValidationErrorOutput output = new ValidationErrorOutput();

        // then
        assertThat(output.getGlobalErrorMessages()).isEmpty();
        assertThat(output.getFieldErrors()).isEmpty();
        assertThat(output.getNumberOfErrors()).isZero();
    }

    @Test
    void addErrorAppendsGlobalMessage() {
        // given
        ValidationErrorOutput output = new ValidationErrorOutput();

        // when
        output.addError("State is mandatory for this country");

        // then
        assertThat(output.getGlobalErrorMessages()).containsExactly("State is mandatory for this country");
    }

    @Test
    void addFieldErrorAppendsFieldError() {
        // given
        ValidationErrorOutput output = new ValidationErrorOutput();

        // when
        output.addFieldError("email", "must not be blank");

        // then
        assertThat(output.getFieldErrors()).hasSize(1);
        assertThat(output.getFieldErrors().get(0).getField()).isEqualTo("email");
        assertThat(output.getFieldErrors().get(0).getMessage()).isEqualTo("must not be blank");
    }

    @Test
    void getNumberOfErrorsCountsFieldErrorsOnly() {
        // given
        ValidationErrorOutput output = new ValidationErrorOutput();
        output.addError("global error");
        output.addFieldError("name", "must not be blank");
        output.addFieldError("email", "must be valid");

        // when
        int count = output.getNumberOfErrors();

        // then
        assertThat(count).isEqualTo(2);
        assertThat(output.getGlobalErrorMessages()).hasSize(1);
    }
}
