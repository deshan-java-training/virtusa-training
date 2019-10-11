package com.emsui.userinterface.validationAnnot;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.security.SecureRandom;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateStrings {

    String[] acceptedValues();

    String message() default "{uk.dds.ideskos.validator.ValidateString.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
