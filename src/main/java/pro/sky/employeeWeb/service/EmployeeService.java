package pro.sky.employeeWeb.service;

import pro.sky.employeeWeb.Employee;

import java.util.Collection;
import java.util.List;


public interface EmployeeService {

    Employee add(String firstName, String lastName,int departmentId,int salary);


    //Employee add(Employee employee);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lasName);

    Collection<Employee> findAll();

}
