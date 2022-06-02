package pro.sky.employeeWeb.service;

import org.springframework.stereotype.Service;
import pro.sky.employeeWeb.Employee;
import pro.sky.employeeWeb.exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee minSalary(int departmentId) {

        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

    }

    @Override
    public Employee maxSalary(int departmentId) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> allEmployees(int departmentId) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());

    }

    @Override
    public List<Employee> allEmployee() {
        return employeeService.findAll().stream()
                .sorted(Comparator.comparing(Employee::getDepartmentId))
                .collect(Collectors.toList());

    }
}
