package br.com.zinid.returnal.application.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MandatoryStateWhenApplicableValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MandatoryStateWhenApplicable {

    String message() default "a valid state must be informed when the country has state(s)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};

}
