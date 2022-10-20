package br.com.zinid.returnal.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdMustExistValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdMustExist {

    String message() default "is not a valid ID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};

    Class<?> entityClass();

}
