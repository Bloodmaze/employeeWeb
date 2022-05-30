package pro.sky.employeeWeb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeBookOverFlowException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Employee book is full";

    public EmployeeBookOverFlowException() {
        super(DEFAULT_MESSAGE);}
}
