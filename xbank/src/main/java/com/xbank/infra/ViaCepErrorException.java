package com.xbank.infra;

public class ViaCepErrorException extends RuntimeException {
    public ViaCepErrorException(String message) {
        super(message);
    }
}
