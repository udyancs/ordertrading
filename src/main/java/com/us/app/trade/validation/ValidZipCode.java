package com.us.app.trade.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = { ZipCodeValidator.class })
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, PARAMETER, METHOD, CONSTRUCTOR, LOCAL_VARIABLE})
public @interface ValidZipCode {
    String message() default "{org.hibernate.validator.constraints.ValidZipCode.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}