package com.epam.graphoundry;

public class CycleException extends RuntimeException {
    public CycleException(String message) {
        super(message);
    }
}
