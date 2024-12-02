package com.George.mcrm.repo;

import com.George.mcrm.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
