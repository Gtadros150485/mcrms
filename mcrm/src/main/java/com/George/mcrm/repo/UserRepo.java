package com.George.mcrm.repo;

import com.George.mcrm.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<AppUser, Long> {

    Optional<?> findByUsername(String username);

    AppUser findByUsernameIs(String username);

}