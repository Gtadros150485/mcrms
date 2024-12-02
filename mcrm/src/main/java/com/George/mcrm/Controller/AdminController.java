package com.George.mcrm.Controller;

import com.George.mcrm.model.AppUser;
import com.George.mcrm.model.Department;
import com.George.mcrm.model.Employee;
import com.George.mcrm.repo.DepartmentRepo;
import com.George.mcrm.repo.EmployeeRepo;
import com.George.mcrm.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private UserService userService;


    @GetMapping("/getAllDeprts")
    ResponseEntity<?> getAllDepartements(@RequestBody Department departement) {
        return (ResponseEntity<?>) departmentRepo.findAll();
    }

    @PostMapping("/addDepartment")
    public Department addDepartement(@RequestBody Department department) {
        return  departmentRepo.save(department);
    }

    @PostMapping("/addEmployee")
    public Optional<?> addEmployee(@RequestBody Employee employee) {
        return Optional.of(employeeRepo.save(employee));
    }

//    @PostMapping("/deleteEmployee")
//    public Optional deleteEmployee(@RequestBody Employee employee) {
//        return Optional.of(employeeRepo.deleteById(employee.getId()));
//    }

    @PostMapping("/updateEmployee")
    public Optional<?> updateEmployee(@RequestBody Employee employee) {
        return Optional.of(employeeRepo.save(employee));
    }
    // Fetch and display users in Thymeleaf view
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsersPage() {
        // Fetch users
        List<AppUser> users = userService.getAllUsers();
        return ResponseEntity.ok(users);  // Return with HTTP status 200 (OK)
    }


}
