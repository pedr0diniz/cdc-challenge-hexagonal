package br.com.zinid.returnal.application.config.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemTest {

    @Test
    void constructorWithFieldsSetsAllValues() {
        // given
        ValidationErrorOutput fields = new ValidationErrorOutput();
        fields.addFieldError("email", "invalid");

        // when
        Problem problem = new Problem(400, "Validation failed", fields);

        // then
        assertThat(problem.getStatus()).isEqualTo(400);
        assertThat(problem.getTitle()).isEqualTo("Validation failed");
        assertThat(problem.getFields()).isSameAs(fields);
        assertThat(problem.getDateTime()).isNotNull();
    }

    @Test
    void constructorWithoutFieldsLeavesFieldsNull() {
        // given / when
        Problem problem = new Problem(404, "Not Found");

        // then
        assertThat(problem.getStatus()).isEqualTo(404);
        assertThat(problem.getTitle()).isEqualTo("Not Found");
        assertThat(problem.getFields()).isNull();
        assertThat(problem.getDateTime()).isNotNull();
    }
}
