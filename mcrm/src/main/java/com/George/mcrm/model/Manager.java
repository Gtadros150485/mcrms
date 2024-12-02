package com.George.mcrm.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "manager")
public class Manager {
    //some previledges
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}