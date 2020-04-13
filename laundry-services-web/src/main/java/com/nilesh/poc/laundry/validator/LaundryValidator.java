package com.nilesh.poc.laundry.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nilesh.poc.laundry.pojos.User;

public class LaundryValidator implements Validator {
    public boolean supports(Class user) {
        return User.class.isAssignableFrom(user);
    }
	public void validate(Object obj, Errors errors) {
		    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_name", "required", "user_name is required.");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_email", "required", "user_email is required.");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_Password", "required", "user_Password is required.");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_mobno", "required", "user_mobno is required.");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_address", "required", "user_address is required.");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "required", "role is required.");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_name", "required", "user_name is required.");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_email", "required", "user_email is required.");
	  		
	}
}
