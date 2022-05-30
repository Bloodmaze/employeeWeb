package pro.sky.employeeWeb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeeWeb.Employee;
import pro.sky.employeeWeb.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final EmployeeServiceImpl employeeService;


    public DepartmentController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam Integer departmentId){
        return employeeService.minSalary(departmentId);
    }
    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int departmentId){

        return employeeService.maxSalary(departmentId);
    }


    @GetMapping("/all")
    public List<Employee> allEmployeers(@RequestParam int departmentId){

        return employeeService.allEmployees(departmentId);
    }
    @GetMapping("/all/grouped")
    public List<Employee> allEmployeersSort(){

        return employeeService.allEmployee();
    }
}
