package com.us.app.trade.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = { IdValidator.class })
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, PARAMETER, METHOD, CONSTRUCTOR, LOCAL_VARIABLE})
public @interface ValidId {
    String message() default "{org.hibernate.validator.constraints.ValidId.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}