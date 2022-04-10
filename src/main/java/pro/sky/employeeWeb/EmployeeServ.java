package pro.sky.employeeWeb;

public interface EmployeeServ {
    Employee addEmployee(String firstName, String lastName);

    Employee addEmployee(Employee employee);

    Employee remove(String firstName, String lastName);

    Employee remove(Employee newEmployee);

    Employee find(String firstName, String lasName);

    Employee[] findAll();
}
