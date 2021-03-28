package com.example.firstspring.demo.validation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

@Component
public class ValidationUtil {

    Validator validator;

    ValidationUtil(Validator validator) {
        this.validator = validator;
    }

    public void validate(Object any) {
        if (validator.validate(any).size() != 0) {
            throw new ConstraintViolationException(validator.validate(any));
        }

    }
}
