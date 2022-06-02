package pro.sky.employeeWeb.Mock;

import pro.sky.employeeWeb.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class TestConstants {
    public static final String FIRST_NAME = "Mark";
    public static final String FIRST_NAME2 = "Anna";
    public static final String LAST_NAME = "Soul";
    public static final String LAST_NAME2 = "Reno";
    public static final int SALARY= 500;
    public static final int MIN_SALARY = 100;
    public static final int DEPARTMENT_ID=1;
    public static final int BAD_DEPARTMENT_ID=2;
    public static final Employee MAX_SALARY_EMPLOYEE=new Employee(FIRST_NAME2,LAST_NAME2,SALARY,DEPARTMENT_ID);
    public static final Employee MIN_SALARY_EMPLOYEE=new Employee(FIRST_NAME,LAST_NAME,MIN_SALARY,DEPARTMENT_ID);
    public static final Set<Employee> EMPLOYEES= Set.of(MIN_SALARY_EMPLOYEE,MAX_SALARY_EMPLOYEE);
    public static final Employee DIFFERENT_DEPARTMENT_EMPLOYEE=new Employee(FIRST_NAME2,LAST_NAME2,SALARY,BAD_DEPARTMENT_ID);
    public static final Set<Employee> DIFFERENT_DEPARTMENT_EMPLOYEES=Set.of(MIN_SALARY_EMPLOYEE,DIFFERENT_DEPARTMENT_EMPLOYEE);
    public static final Map<Integer,List<Employee>> DEPARTMENT_MAP= DIFFERENT_DEPARTMENT_EMPLOYEES.stream().collect(groupingBy(Employee::getDepartmentId));

}
