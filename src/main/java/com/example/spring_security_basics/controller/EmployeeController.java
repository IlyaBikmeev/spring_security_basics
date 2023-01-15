package com.example.spring_security_basics.controller;

import com.example.spring_security_basics.model.Employee;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivan", "Ivanov"),
            new Employee("Andrey", "Andreev")
    ));

    @GetMapping
    @PreAuthorize("hasAuthority('employees:read')")
    public List<Employee> getEmployees() {
        return employees;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('employees:read')")
    public Employee getById(@PathVariable int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst().orElse(null);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('employees:write')")
    public Employee createEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('employees:write')")
    public void deleteById(@PathVariable int id) {
        employees.removeIf(e -> e.getId() == id);
    }

}
