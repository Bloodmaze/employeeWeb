package pro.sky.employeeWeb.service;

import org.springframework.stereotype.Service;
import pro.sky.employeeWeb.Employee;
import pro.sky.employeeWeb.exception.EmployeeBookOverFlowException;
import pro.sky.employeeWeb.exception.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    @Override
    public Employee minSalary(int departmentId) {

        return employees.values().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

    }
    @Override
    public Employee maxSalary(int departmentId) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
    @Override
    public List<Employee> allEmployees(int departmentId){
        return employees.values().stream()
                .filter(employee -> employee.getDepartmentId()==departmentId)
                .collect(Collectors.toList());

    }
    @Override
    public List<Employee> allEmployee(){
        return employees.values().stream()
                .sorted(Comparator.comparing(Employee::getDepartmentId))
                .collect(Collectors.toList());

    }




    @Override
    public Employee add(String firstName, String lastName, int departmentId, int salary) {
        Employee newEmployee = new Employee(firstName, lastName, departmentId, salary);
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
