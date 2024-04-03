package com.Nyamah.apis.validator;



import java.util.regex.Pattern;

import com.Nyamah.apis.CustomAnnotation.MobileNumber;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileNumberValidator implements ConstraintValidator<MobileNumber, String> {

	private static final String MOBILE_NUMBER_REGEX = "^[6-9]\\d{9}$";
	private static final Pattern MOBILE_NUMBER_PATTERN = Pattern.compile(MOBILE_NUMBER_REGEX);

	@Override
	public void initialize(MobileNumber constraintAnnotation) {
	}

	@Override
	public boolean isValid(String mobileNumber, ConstraintValidatorContext context) {
		return mobileNumber == null || MOBILE_NUMBER_PATTERN.matcher(mobileNumber).matches();
	}
}

