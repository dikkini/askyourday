package com.askyourday.exception;


public class InternalErrorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;

    public InternalErrorException(String message, int code) {
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
