package com.ambiasystems.aria.patient.annotaion;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.ambiasystems.aria.patient.validator.AgeValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {

	String message() default "User is under-aged to register";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}