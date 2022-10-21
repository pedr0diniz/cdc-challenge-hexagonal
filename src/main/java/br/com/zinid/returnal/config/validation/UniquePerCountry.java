package br.com.zinid.returnal.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniquePerCountryValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePerCountry {

    String message() default "already exists in the given country";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};

}
