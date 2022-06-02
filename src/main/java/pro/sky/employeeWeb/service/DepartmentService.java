package pro.sky.employeeWeb.service;

import pro.sky.employeeWeb.Employee;

import java.util.List;

public interface DepartmentService {


    Employee minSalary(int departmentId);

    Employee maxSalary(int departmentId);

    List<Employee> allEmployees(int departmentId);

    List<Employee> allEmployee();
}

