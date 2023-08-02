package com.example.banking.controllers;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.banking.models.Admin;
import com.example.banking.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "admin/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Validate admin login credentials
        Admin admin = adminService.getAdminByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            // If valid, redirect to admin dashboard or approve account creation page(as per admin module)
            return "admin/dashboard";
        } else {
            // If invalid, show error message on the login page
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "admin/login";
        }
    }

    @RequestMapping("/approve")
    public String approveAccountCreation(Model model) {
        //logic to get pending account creation requests
        // and pass the list to the approve-account.jsp page
        // List<AccountCreationRequest> pendingRequests = ...
        // model.addAttribute("pendingRequests", pendingRequests);
        return "admin/approve-account"; 
    }

    // will add more admin functionalities here

}

