package com.example.spring_security_basics.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Employee {
    @JsonIgnore
    private static int COUNT = 0;
    private int id;
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.id = ++COUNT;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
