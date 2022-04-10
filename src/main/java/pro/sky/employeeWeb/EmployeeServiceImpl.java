package pro.sky.employeeWeb;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeServ {

    private Employee[] employees;
    private int size;

    public EmployeeServiceImpl() {
        employees=new Employee[10];


    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return addEmployee(newEmployee);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (size == employees.length) throw new EmployeeBookOverFlowException();
        int index = indexOf(employee);
        if (index != -1) {
            throw new EmployeeBookOverFlowException();
        }
        employees[size++] = employee;
        return employee;

    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee newEmployee) {
        int index = indexOf(newEmployee);
        if(index!=-1){
            Employee result=employees[index];
            System.arraycopy(employees,index+1,employees,index,size-index);
            size--;
            return result;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName,String lasName){
        Employee newEmployee=new Employee(firstName,lasName);
        int index=indexOf(newEmployee);
        if (index!=-1){
            return employees[index];
        }
        throw new EmployeeNotFoundException();

    }
    @Override
    public Employee[] findAll(){
        return employees;
    }
    private int indexOf(Employee employee){
        for (int i = 0; i <size ; i++) {
            if(employees[i].equals(employee)){
                return i;
            }
            
        }
        return -1;
    }



}
