package com.example.firstspring.demo.controller;

import com.example.firstspring.demo.error.NotFoundException;
import com.example.firstspring.demo.model.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public Response<String> validationHandler(ConstraintViolationException constraintViolationException) {
        return new Response<>(
                400,
                "Bad Request",
                constraintViolationException.getMessage()
        );
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public Response<String> notFound() {
        return new Response<>(
                404,
                "Not Found",
                "Not found"
        );
    }
}
