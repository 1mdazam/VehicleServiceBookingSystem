package com.azam.vehicleservicebookingsystem.controller;

import com.azam.vehicleservicebookingsystem.entity.User;
import com.azam.vehicleservicebookingsystem.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showLoginPage(Model model,
                                @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("error", error);
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password,
                              HttpSession session) {
        User validUser = userService.validateUser(username, password);
        if (validUser != null) {
            session.setAttribute("username", validUser.getUsername());
            return "redirect:/vehicles-page";
        } else {
            return "redirect:/?error=Invalid username or password!";
        }
    }

    @PostMapping("/register")
    public String handleRegister(@RequestParam String username,
                                 @RequestParam String password) {
        User existingUser = userService.getUserByUsername(username);
        if (existingUser != null) {
            return "redirect:/?error=Username already exists!";
        }
        userService.registerUser(new User(username, password));
        return "redirect:/?error=Registration successful! Please log in.";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/?error=Logged out successfully!";
    }
}
