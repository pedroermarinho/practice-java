package org.example.rinhabackend2024q1springbootjpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ResourceExceptionHandler {



    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException exception)
    {
        Map<String,String>errorMap=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->
                errorMap.put(error.getField(),error.getDefaultMessage()));
        return errorMap;
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String,String> handleInvalidArgument(HttpMessageNotReadableException exception)
    {
        Map<String,String>errorMap=new HashMap<>();
        errorMap.put("error",exception.getMessage());
        return errorMap;
    }

}
