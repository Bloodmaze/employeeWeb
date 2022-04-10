package pro.sky.employeeWeb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")


public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
///

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName){
        Employee result=employeeService.add(firstName,lastName);
        return generateMessage(result,"создан");}
    @GetMapping("/remove")
        public String remove(@RequestParam String firstName,@RequestParam  String lastName){
        Employee result=employeeService.remove(firstName,lastName);
        return generateMessage(result,"удален");}
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,@RequestParam String lastName){
        return employeeService.find(firstName,lastName);}
    @GetMapping("/all")
    public Employee[] all(@RequestParam String firstName, @RequestParam String lastName){
        return employeeService.findAll();}
    public String generateMessage(Employee employee, String status){
        return String.format("сотрудник",employee.getLastName(),employee.getFirstName(),status);






    }
}
