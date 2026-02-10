package org.example.customexceptions;

public class ContextNotFoundException extends RuntimeException {
    public ContextNotFoundException(String message) { super(message);}
}
