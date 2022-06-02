package pro.sky.employeeWeb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeeWeb.Employee;
import pro.sky.employeeWeb.service.DepartmentServiceImpl;
import pro.sky.employeeWeb.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;


    public DepartmentController(DepartmentServiceImpl departmentService) {

        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam Integer departmentId) {
        return departmentService.minSalary(departmentId);
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int departmentId) {

        return departmentService.maxSalary(departmentId);
    }


    @GetMapping("/all")
    public List<Employee> allEmployeers(@RequestParam int departmentId) {

        return departmentService.allEmployees(departmentId);
    }

    @GetMapping("/all/grouped")
    public List<Employee> allEmployeersSort() {

        return departmentService.allEmployee();
    }
}
