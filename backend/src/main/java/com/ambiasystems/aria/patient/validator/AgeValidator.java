package com.ambiasystems.aria.patient.validator;

import com.ambiasystems.aria.patient.annotaion.Age;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		return age!=null ? age>=18 : false ;
	}

}
