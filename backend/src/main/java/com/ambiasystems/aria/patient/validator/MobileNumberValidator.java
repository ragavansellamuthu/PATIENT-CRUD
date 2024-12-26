package com.ambiasystems.aria.patient.validator;

import com.ambiasystems.aria.patient.annotaion.MobileNumber;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileNumberValidator implements ConstraintValidator<MobileNumber, Long> {

	@Override
	public boolean isValid(Long mobileNumber, ConstraintValidatorContext context) {
		return mobileNumber!=null ? mobileNumber>=6000000000L && mobileNumber<=9999999999L : false ;
	}

}
