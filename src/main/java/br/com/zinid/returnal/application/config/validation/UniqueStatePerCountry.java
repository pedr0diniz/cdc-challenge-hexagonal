package br.com.zinid.returnal.application.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueStatePerCountryValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueStatePerCountry {

    String message() default "already exists in the given country";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};

}
