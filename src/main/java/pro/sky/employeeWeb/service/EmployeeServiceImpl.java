package pro.sky.employeeWeb.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.employeeWeb.Employee;
import pro.sky.employeeWeb.exception.AddingAnExistingEmployeeException;
import pro.sky.employeeWeb.exception.EmployeeBookOverFlowException;
import pro.sky.employeeWeb.exception.EmployeeNotFoundException;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }


    @Override
    public Employee add(String firstName, String lastName, int departmentId, int salary) {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)) {
            throw new AddingAnExistingEmployeeException();

        }
        Employee newEmployee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), departmentId, salary);
        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeBookOverFlowException();
        }
        employees.put(firstName + lastName, newEmployee);
        return newEmployee;
    }


    @Override
    public Employee remove(String firstName, String lastName) {
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(firstName + lastName);
    }


    @Override
    public Employee find(String firstName, String lastName) {
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(firstName + lastName);

    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

}
