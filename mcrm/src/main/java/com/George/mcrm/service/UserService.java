package com.George.mcrm.service;


import com.George.mcrm.model.AppUser;
import com.George.mcrm.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public List<AppUser> getAllUsers() {
        return userRepo.findAll();
    }
}
