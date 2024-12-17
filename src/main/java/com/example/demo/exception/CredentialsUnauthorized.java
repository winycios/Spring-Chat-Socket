package com.example.demo.exception;

public class CredentialsUnauthorized extends RuntimeException {

    public CredentialsUnauthorized(String message) {
        super(message);
    }
    public CredentialsUnauthorized() {
        super("Credenciais inválidas.");
    }
}
