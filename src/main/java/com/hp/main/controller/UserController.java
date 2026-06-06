package com.hp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.hp.main.model.User;
import com.hp.main.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Show all users
    @GetMapping("/users")
    public String viewUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    // Show form
    @GetMapping("/addUser")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "user_form";
    }

    // Save user
    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") User user,
                           BindingResult result,
                           Model model) {

        if (result.hasErrors()) {
            return "user_form";
        }

        if (user.getId() == null && userService.emailExists(user.getEmail())) {
            model.addAttribute("emailError", "Email already exists!");
            return "user_form";
        }

        userService.saveUser(user);
        return "redirect:/users";
    }

    // Edit
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user_form";
    }

    // Delete
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
