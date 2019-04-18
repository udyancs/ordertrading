package com.us.app.trade.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * This class is the implementation for the ValidId annotation.
 */
public class IdValidator implements ConstraintValidator<ValidId, String> {

    @Override
    public void initialize(ValidId validId) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext context) {
        return contactField != null;
    }
}
