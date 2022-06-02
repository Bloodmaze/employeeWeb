package pro.sky.employeeWeb.Mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employeeWeb.exception.EmployeeNotFoundException;
import pro.sky.employeeWeb.service.DepartmentServiceImpl;
import pro.sky.employeeWeb.service.EmployeeService;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.employeeWeb.Mock.TestConstants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldFindEmployeeWithMaxSalaryByDepartmentId() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, out.maxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMaxSalaryInEmptyEmployeesList() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertThrows(EmployeeNotFoundException.class, () -> out.maxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMaxSalaryInEmptyDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.maxSalary(BAD_DEPARTMENT_ID));
    }

    @Test
    public void shouldFindEmployeeWithMinSalaryByDepartmentId() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, out.minSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMinSalaryInEmptyEmployeesList() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertThrows(EmployeeNotFoundException.class, () -> out.minSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMinSalaryInEmptyDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.minSalary(BAD_DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnAllEmployeesByDepartmentsWhenEmployeesExist() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);
        assertEquals(DEPARTMENT_MAP, out.allEmployee());
    }

    @Test
    public void shouldReturnEmptyMapWhenEmployeesDontExist() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertEquals(emptyMap(), out.allEmployee());
    }

    @Test
    public void shouldReturnEmployeesByDepartmentIsCorrectAndEmployeesExistThere() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);
        assertEquals(singletonList(MIN_SALARY_EMPLOYEE), out.allEmployees(DEPARTMENT_ID));
        assertEquals(singletonList(DIFFERENT_DEPARTMENT_EMPLOYEE), out.allEmployees(BAD_DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmptyListWhenEmployeesDontFoundIdDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(emptyList(), out.allEmployees(BAD_DEPARTMENT_ID));
    }


}
