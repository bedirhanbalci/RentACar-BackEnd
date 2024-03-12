package com.tobeto.pair6.rentACar.core.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException businessException) {

        ProblemDetails problemDetails = new ProblemDetails();

        problemDetails.setMessage(businessException.getMessage());

        return problemDetails;

    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidException(MethodArgumentNotValidException methodArgumentNotValidException) {

        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();

        validationProblemDetails.setMessage("VALIDATION.EXCEPTION");

        validationProblemDetails.setValidationErrors(new HashMap<String, String>());

        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {

            validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());

        }

        return validationProblemDetails;

    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(Exception exception) {

        return exception.getMessage();

    }

}
