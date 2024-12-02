package com.George.mcrm.service;

import com.George.mcrm.repo.AdminRepo;
import com.George.mcrm.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private DepartmentRepo departmentRepo;


    public ResponseEntity<?> getAllDepartements() {
        return (ResponseEntity<?>) adminRepo.findAll();
    }



}
