package com.Nil.Electronic.Shop.Validate;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.slf4j.LoggerFactory;

import java.lang.annotation.*;
import java.util.logging.Logger;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { ImageNameValidator.class })
public @interface ImageNameValid {

    //	errro message
    String message() default "Invalid Image Name";

    //	represent group of contraints
    Class<?>[] groups() default { };

//	additional Imformation about Annotation

    Class<? extends Payload>[] payload() default { };
}
