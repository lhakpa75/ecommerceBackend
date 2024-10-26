package com.lhakpa.ecommerce.ExceptionHandler;

public class GlobalExceptionHandler extends RuntimeException {
    public GlobalExceptionHandler(String message) {
        super(message);
    }
}
