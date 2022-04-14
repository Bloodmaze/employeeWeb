package pro.sky.employeeWeb;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeServ {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }


    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeBookOverFlowException();
        }
        employees.put(firstName + lastName, newEmployee);
        return newEmployee;
    }

    @Override
    public Employee add(Employee employee) {
        return null;

    }

    @Override
    public Employee remove(String firstName, String lastName) {
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(firstName + lastName);
    }

    @Override
    public Employee remove(Employee employee) {
        return null;

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
