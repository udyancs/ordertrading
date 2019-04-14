package com.us.app.trade.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * This class is the implementation for the ValidZipCode annotation.
 */
public class ZipCodeValidator implements ConstraintValidator<ValidZipCode, String> {

    @Override
    public void initialize(ValidZipCode validZipCode) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext context) {
        return contactField != null && contactField.matches("[0-9]+")
                && (contactField.length() > 4) && (contactField.length() < 10);
    }
}
