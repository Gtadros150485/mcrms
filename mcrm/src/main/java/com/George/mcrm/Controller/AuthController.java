package com.George.mcrm.Controller;

import com.George.mcrm.model.AppUser;
import com.George.mcrm.model.LoginForm;
import com.George.mcrm.repo.UserRepo;
import com.George.mcrm.service.JwtService;
import com.George.mcrm.service.UserAuthDetailedService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;


    @Autowired
    private UserAuthDetailedService userAuthDetailedService;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/logged")
    public String logged() {
        return "Welcome To our application";
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/admin/home")
    public String handleAdminHome() {
        return "Welcome to ADMIN home!";
    }

    @GetMapping("/user/home")
    public String handleUserHome() {
        return "Welcome to USER home!";
    }

    @PostMapping("/authenticate")
    //@ResponseBody annotation for postman JSON testing
    public String authenticateAndGetToken(@RequestParam String username, @RequestParam String password,  HttpServletResponse response) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
               username, password
        ));
        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(userAuthDetailedService.loadUserByUsername(username));

            // Add the token as a cookie
            Cookie jwtCookie = new Cookie("jwtToken", token);
            jwtCookie.setPath("/");      // Set cookie path
            jwtCookie.setMaxAge(60 * 60); // Set expiration time (1 hour)
            response.addCookie(jwtCookie);
            AppUser appUser = userRepo.findByUsernameIs(username);
            String role = appUser.getRole();
            // Store the token in the session
            if(role != null) {
                if (role.contains("ADMIN")) {
                  return "admin";
                }
                if (role.contains("EMPLOYEE")) {
                   return "employee";
                }
                if (role.contains("MANAGER")) {
                     return "manager";
                }
            }
            return "User Has no role";
        } else {
            // return new RedirectView("/login?error=true");
            return "Unauthorized";
        }
    }
}