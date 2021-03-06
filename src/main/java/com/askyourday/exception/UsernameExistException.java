package com.askyourday.exception;

import org.springframework.security.core.AuthenticationException;

public class UsernameExistException extends AuthenticationException {
    private static final long serialVersionUID = 1L;

    private int code;

    public UsernameExistException(String message) {
        super(message);
    }

    public UsernameExistException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
