package com.George.mcrm.repo;

import com.George.mcrm.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

    @Override
    List<Department> findAll();



}
