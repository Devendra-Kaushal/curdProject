package com.dev.curdProject.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = FlightMfdByValidator.class)
public @interface flightMfdBy {
	
	public String message() default "The Manufature Value is not Vaild";
	
	public Class<?>[] groups() default{};
	
	public Class<? extends Payload>[] payload() default {};

}
