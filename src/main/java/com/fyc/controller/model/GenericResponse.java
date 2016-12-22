package com.fyc.controller.model;

import java.io.Serializable;

public class GenericResponse<T> implements Serializable {

    private static final long serialVersionUID = -3583994886157629752L;

    private final T message;

    private GenericResponse(T message) {
        this.message = message;
    }

    public static <T> GenericResponse<T> createResponse(T message) {
        return new GenericResponse<T>(message);
    }

    public T getMessage() {
        return message;
    }
}
