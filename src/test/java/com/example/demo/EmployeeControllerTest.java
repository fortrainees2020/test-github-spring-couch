package com.example.demo;

import com.example.demo.controller.EmployeeController;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {

    private EmployeeService employeeService;
    private EmployeeController controller;

    @BeforeEach
    void setUp() {
        employeeService = mock(EmployeeService.class);
        controller = new EmployeeController(employeeService);
    }

    @Test
    void testCreateEmployee() {
        Employee emp = new Employee("101", "John", "Developer", "IT");
        when(employeeService.save(emp)).thenReturn(emp);

        ResponseEntity<Employee> response = controller.create(emp);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("John", response.getBody().getName());
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> list = Arrays.asList(
                new Employee("101", "John", "Developer", "IT"),
                new Employee("102", "Jane", "QA", "Testing")
        );
        when(employeeService.findAll()).thenReturn(list);

        ResponseEntity<List<Employee>> response = controller.getAll();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testGetById() {
        Employee emp = new Employee("101", "John", "Developer", "IT");
        when(employeeService.findById("101")).thenReturn(emp);

        ResponseEntity<Employee> response = controller.getById("101");
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("John", response.getBody().getName());
    }

    @Test
    void testUpdateEmployee() {
        Employee emp = new Employee("101", "John", "Developer", "IT");
        when(employeeService.update(emp)).thenReturn(emp);

        ResponseEntity<Employee> response = controller.update(emp);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Developer", response.getBody().getDesignation());
    }

    @Test
    void testDeleteEmployee() {
        Employee emp = new Employee("101", "John", "Developer", "IT");
        doNothing().when(employeeService).delete(emp);

        ResponseEntity<Void> response = controller.delete(emp);
        assertEquals(204, response.getStatusCodeValue());
        verify(employeeService, times(1)).delete(emp);
    }
}
