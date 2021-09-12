package dev.patika.patika0601.exceptions;

public class EmployeeExistException extends RuntimeException{

    public EmployeeExistException(String message) {
        super(message);
    }
}
