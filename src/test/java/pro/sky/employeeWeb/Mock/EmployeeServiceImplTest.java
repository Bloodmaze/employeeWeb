package pro.sky.employeeWeb.Mock;

import org.junit.jupiter.api.Test;
import pro.sky.employeeWeb.Employee;
import pro.sky.employeeWeb.exception.EmployeeBookOverFlowException;
import pro.sky.employeeWeb.exception.EmployeeNotFoundException;
import pro.sky.employeeWeb.service.EmployeeServiceImpl;


import java.util.Collection;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.employeeWeb.Mock.TestConstants.*;

class EmployeeServiceImplTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    public void shouldAddEmployeeWhenTheyDontExist() {
        Employee expected = new Employee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertEquals(0, out.findAll().size());
        assertFalse(out.findAll().contains(expected));
        Employee actual = out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertEquals(expected, actual);
        assertEquals(1, out.findAll().size());
        assertTrue(out.findAll().contains(expected));

    }


    @Test
    public void shouldThrowEmployeeExistsExceptionWhenTheyExist() {
        Employee existed = out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertTrue(out.findAll().contains(existed));
        assertThrows(EmployeeBookOverFlowException.class,
                () -> out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID));
    }


    @Test
    public void shouldFindEmployeeWhenTheyExist() {
        Employee existed = out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertEquals(existed, out.find(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWhichDoesntExist() {
        assertEquals(0, out.findAll().size());
        assertThrows(EmployeeNotFoundException.class, () -> out.find(FIRST_NAME, LAST_NAME));

    }

    @Test
    public void shouldRemoveEmployeeWhenTheyExist() {
        Employee expected = out.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertEquals(1, out.findAll().size());
        assertTrue(out.findAll().contains(expected));
        Employee actual = out.remove(FIRST_NAME, LAST_NAME);
        assertEquals(expected, actual);
        assertTrue(out.findAll().isEmpty());
        assertFalse(out.findAll().contains(expected));

    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenRemoveEmployeeWhichDoesntExist() {
        assertTrue(out.findAll().isEmpty());
        assertThrows(EmployeeNotFoundException.class, () -> out.remove(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldReturnEmptyCollectionWhenEmployeesWhichDoesntExist() {
        assertIterableEquals(emptyList(), out.findAll());
    }


}
