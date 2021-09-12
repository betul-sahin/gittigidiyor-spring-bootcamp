package dev.patika.patika0601.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String msg){
        super(msg);
    }
}
