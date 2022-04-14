package pro.sky.employeeWeb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeBookOverFlowException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Employee book is full";

    public EmployeeBookOverFlowException() {
        super(DEFAULT_MESSAGE);
    }

    public EmployeeBookOverFlowException(String message) {
        super(message);
    }

    public EmployeeBookOverFlowException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeBookOverFlowException(Throwable cause) {
        super(cause);
    }

    public EmployeeBookOverFlowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
