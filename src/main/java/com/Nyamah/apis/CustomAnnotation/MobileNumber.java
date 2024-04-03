package com.Nyamah.apis.CustomAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.Nyamah.apis.validator.MobileNumberValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Documented
@Constraint(validatedBy = MobileNumberValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MobileNumber {
	String message() default "Invalid mobile number";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
