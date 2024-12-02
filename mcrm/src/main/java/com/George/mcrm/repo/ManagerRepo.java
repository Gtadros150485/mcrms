package com.George.mcrm.repo;

import com.George.mcrm.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager, Long> {

}