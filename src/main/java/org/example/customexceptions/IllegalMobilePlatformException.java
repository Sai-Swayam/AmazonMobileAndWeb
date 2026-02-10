package org.example.customexceptions;

public class IllegalMobilePlatformException extends RuntimeException {
    public IllegalMobilePlatformException(String message) {
        super(message);
    }
}
