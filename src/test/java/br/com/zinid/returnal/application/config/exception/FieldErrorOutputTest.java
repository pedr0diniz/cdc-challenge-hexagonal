package br.com.zinid.returnal.application.config.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FieldErrorOutputTest {

    @Test
    void constructorAndGettersReturnCorrectValues() {
        // given / when
        FieldErrorOutput fieldError = new FieldErrorOutput("email", "must be a valid email");

        // then
        assertThat(fieldError.getField()).isEqualTo("email");
        assertThat(fieldError.getMessage()).isEqualTo("must be a valid email");
    }
}
