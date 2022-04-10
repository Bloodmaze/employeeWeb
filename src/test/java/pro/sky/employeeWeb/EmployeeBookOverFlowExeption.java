package pro.sky.employeeWeb;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeBookOverFlowExeption extends Throwable {
    private static final String DEFAULT_MESSAGE = "Employee not found";

    public EmployeeBookOverFlowExeption() {
        super(DEFAULT_MESSAGE);
    }

    public EmployeeBookOverFlowExeption(String message) {
        super(message);
    }

    public EmployeeBookOverFlowExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeBookOverFlowExeption(String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace) {
        super(message, cause, enableSuppresion, writableStackTrace);
    }


}
