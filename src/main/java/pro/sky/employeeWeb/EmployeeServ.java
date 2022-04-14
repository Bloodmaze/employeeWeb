package pro.sky.employeeWeb;

import org.springframework.stereotype.Service;

import java.util.Collection;


public interface EmployeeServ {
    Employee add(String firstName, String lastName);

    Employee add(Employee employee);

    Employee remove(String firstName, String lastName);

    Employee remove(Employee newEmployee);

    Employee find(String firstName, String lasName);

    Collection<Employee> findAll();
}
