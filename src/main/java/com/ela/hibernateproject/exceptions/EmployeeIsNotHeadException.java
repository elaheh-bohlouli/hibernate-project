package com.ela.hibernateproject.exceptions;

public class EmployeeIsNotHeadException extends Exception{
    public EmployeeIsNotHeadException() {
        super("Employee Is Not A Manager ....! ");
    }
}
