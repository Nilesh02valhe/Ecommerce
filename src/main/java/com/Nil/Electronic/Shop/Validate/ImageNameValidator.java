package com.Nil.Electronic.Shop.Validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageNameValidator implements ConstraintValidator<ImageNameValid, String> {


    private Logger logger= LoggerFactory.getLogger(ImageNameValid.class);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        logger.info("Message from isValid : {}", value);

        if(value.isBlank()) {
            return false;
        } else {
            return true;
        }
    }



}
