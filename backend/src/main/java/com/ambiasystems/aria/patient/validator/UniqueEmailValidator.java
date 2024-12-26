package com.ambiasystems.aria.patient.validator;

import org.springframework.util.StringUtils;

import com.ambiasystems.aria.patient.annotaion.UniqueEmail;
import com.ambiasystems.aria.patient.service.PatientService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{

	@NonNull
	private final PatientService patientService;
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return StringUtils.hasText(email)?!patientService.isDuplicateEmail(0,email):false;
	}

}
