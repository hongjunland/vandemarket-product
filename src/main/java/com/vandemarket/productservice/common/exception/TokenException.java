package com.vandemarket.productservice.common.exception;

public class TokenException extends RuntimeException {
    public TokenException(String msg) {
        super(msg);
    }
}