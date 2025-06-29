// EmployeeService.java
package com.example.demo.service;

import com.example.demo.model.Employee;
import org.lightcouch.CouchDbClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final CouchDbClient couchDbClient;

    public EmployeeService(CouchDbClient couchDbClient) {
        this.couchDbClient = couchDbClient;
    }

    public Employee save(Employee employee) {
        couchDbClient.save(employee);
        return employee;
    }

    public List<Employee> findAll() {
        return couchDbClient.view("_all_docs")
                .includeDocs(true)
                .query(Employee.class);
    }

    public Employee findById(String id) {
        return couchDbClient.find(Employee.class, id);
    }

    public Employee update(Employee employee) {
        couchDbClient.update(employee);
        return employee;
    }

    public void delete(Employee employee) {
        couchDbClient.remove(employee);
    }
}
