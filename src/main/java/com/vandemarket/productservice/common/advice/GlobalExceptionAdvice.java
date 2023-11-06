package com.vandemarket.productservice.common.advice;

import com.vandemarket.productservice.common.ApiResponse;
import com.vandemarket.productservice.common.ErrorApiResponse;
import com.vandemarket.productservice.common.exception.TokenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(TokenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleTokenException(TokenException ex) {
        return ErrorApiResponse.of(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
