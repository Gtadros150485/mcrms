package com.George.mcrm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long emid;

    @ElementCollection
    private Set<String> roles = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "department_id", unique = true)  // Ensures one-to-one constraint
    private Department department;
}
